
import java.util.ArrayList;
import java.util.Scanner;


public class MobilePhone {

    private SaveContacts saveContacts;
    private ArrayList<Contacts> listContacts;
    private AddRemoveUpdateSearchContact addAndRemoveContact;
    Scanner sc = new Scanner(System.in);

    public ArrayList<Contacts> getListContacts() {
        return listContacts;
    }
    public void setListContacts(ArrayList<Contacts> listContacts) {
        this.listContacts = listContacts;
    }
    public void start() {
        System.out.println("Hello , this is your mobile Phone: ");
        this.listContacts = new ArrayList<>();
        this.saveContacts = new SaveContacts();
        this.addAndRemoveContact = new AddRemoveUpdateSearchContact();
        options();
    }

    private void options() {
        boolean isQuit = false, isInt;
        int choose;
        menu();

        do {
            System.out.println("choose options (available options 6 ) > ");
            isInt = sc.hasNextInt();

            if(isInt) {
                choose = sc.nextInt();
                sc.nextLine();
                switch (choose) {
                    case 1:
                    {
                        printListOfContacts();
                        break;
                    }
                    case 2:
                    {
                        addAndRemoveContact.addNewContact(listContacts);
                        break;
                    }
                    case 3:
                    {
                        addAndRemoveContact.updateExistingContact(listContacts);
                        break;
                    }
                    case 4:
                    {
                        addAndRemoveContact.removeContact(listContacts);
                        break;
                    }
                    case 5:
                    {
                        addAndRemoveContact.searchContact(listContacts);
                        break;
                    }
                    case 6:
                    {
                       menu();
                       break;
                    }
                    case 7:
                    {
                        isQuit = true;
                        System.out.println("exits from program !!!");
                            saveContacts.finishSaveContacts(listContacts);

                        break;
                    }
                    default: {
                        System.out.println("wrong option !!!");
                        break;
                    }
                }

            } else {
                System.out.println("wrong value ... please again ");
                sc.nextLine();
            }


        }while( ! isQuit);

    }



    void findNumber() {
        long phoneNumber;
        boolean ifInt;
        System.out.println("choose phone number: ");
        ifInt = sc.hasNextLong();

        if(ifInt) {
            phoneNumber = sc.nextLong();
            sc.nextLine();
            //search by phone number
            boolean result = onListContactsByPhoneNumber(phoneNumber);
            if(result) {
                //show by phone number
                showMeContact(phoneNumber);
            } else {
                System.out.println("no contact by phone number");
            }
        } else {
            sc.nextLine();
            System.out.println("wrong value ...");
        }
    }

    void findName() {
        String name;
        boolean result;
        do {
            result = true;
            System.out.println("choose name: ");
            name = sc.nextLine();

            if (name.equals("")) {
                result = false;
                System.out.println("error, empty field, please again ...");
            }
        }while( ! result);

            //search by name
            boolean ifContactByName = onListContactsByName(name, listContacts);
            if(ifContactByName) {
                showMeContact(name);
            } else {
                System.out.println("no contact by name ");
            }

    }

    private void showMeContact(String name) {

        for (Contacts contactSearch : listContacts) {
            if(contactSearch.getName().equals(name)) {
                System.out.println("name: " + contactSearch.getName() + ", phone number: " + contactSearch.getNumberPhone());
            }
        }
    }


    private void showMeContact(long phoneNumber) {

        for (Contacts contactSearch : listContacts) {
            if( contactSearch.getNumberPhone() == phoneNumber ) {
                System.out.println("name: " + contactSearch.getName() + ", phone number: " + contactSearch.getNumberPhone());
            }
        }
    }



    public void modifyContact(int chooseContact) {

        Contacts modifyContact = listContacts.get(chooseContact);
        System.out.println("modify name: " );

        boolean result;
        String name;
        do {
            result = true;
            System.out.println("enter the name contact: ");
            name = sc.nextLine();
            if(name.equals("")) {result = false; }

        } while ( ! isTrueOfFalse(result)); //if true -> go out loop



        boolean ifInt;
        do {
            System.out.println("enter the phone number: ");
            ifInt = sc.hasNextInt();
            if(ifInt == false) { sc.nextLine(); }

        } while ( ! isTrueOfFalse(ifInt));

        long phoneNumber = sc.nextInt();
        sc.nextLine();

        boolean isThereContactOnList = onListContactsByName(name, listContacts);

        if (! isThereContactOnList) { //if false , then modify contact
            modifyContact.setName(name); //change name and phone number
            modifyContact.setNumberPhone(phoneNumber);
            System.out.println("change of contact details ");
        }

    }



    //checks by name search
    public boolean onListContactsByName(String name, ArrayList<Contacts> listContacts) {

        if( ! listContacts.isEmpty()) {

            for (Contacts contactsName : listContacts) {
                if (contactsName.getName().equals(name)) {
                    System.out.println("there is already contact on the list");
                    return true;
                }
            }
        }
        return false;
    }


    //checks by number search
    private boolean onListContactsByPhoneNumber(long number) {

        for (Contacts contactsPhoneNumber : listContacts) {
            if (contactsPhoneNumber.getNumberPhone() == number) {
                System.out.println("there is already contact on the list");
                return true;
            }
        }
        return false;

    }

    public boolean isTrueOfFalse(boolean isExistNameOrPhoneNumber) {
        if(isExistNameOrPhoneNumber) {
            return true;
        } else {
            System.out.println("wrong name or phone number ... ");
            return false;
        }
    }

    public void printListOfContacts() {

        if(listContacts.isEmpty() ) {
            System.out.println("no saved contacts ... ");
        } else {
            int i = 1;
            for(Contacts contacts : listContacts) {
                System.out.println((i++) + ". name: " + contacts.getName() + ", phone number : " + contacts.getNumberPhone());
            }
        }
    }

    private void menu() {
        System.out.println("*********** MENU **********");
        System.out.println("\t1. Print list of contacts");
        System.out.println("\t2. Add new contact");
        System.out.println("\t3. Update existing contact");
        System.out.println("\t4. Remove contact");
        System.out.println("\t5. Search contact");
        System.out.println("\t6. Show menu");
        System.out.println("\t7. Quit and save contacts in file txt");
    }
}

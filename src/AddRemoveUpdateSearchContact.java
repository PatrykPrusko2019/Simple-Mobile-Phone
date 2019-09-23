import java.util.ArrayList;

public class AddRemoveUpdateSearchContact extends MobilePhone {



    public void addNewContact(ArrayList<Contacts> listContacts) {

        System.out.println("********** add contact *************");
        boolean corectName;
        String name;

        do {
            corectName = true;
            System.out.println("enter the name contact: ");
            name = sc.nextLine();

            if(name.equals("")) { corectName = false;
            System.out.println("error, empty field, please again ..."); } //no null value of String


        } while ( ! isTrueOfFalse(corectName));//if true -> go out loop

        boolean ifInt;
        do {
            System.out.println("enter the phone number: ");
            ifInt = sc.hasNextLong();
            if(ifInt == false) { sc.nextLine();}

        } while ( ! isTrueOfFalse(ifInt)); //if true -> go out loop

        long phoneNumber = sc.nextLong();
        sc.nextLine();

        //we check if the contact is repeated
        boolean ifAddContact = onListContactsByName(name, listContacts);

        //if false add new contact
        if( ! ifAddContact) {
            Contacts contacts = new Contacts(name, phoneNumber);
            listContacts.add(contacts);
            setListContacts(listContacts);
            System.out.println("adding a new contact to the list ");
        } else {
            System.out.println("the contact cannot be added...");
        }

    }

    public void removeContact(ArrayList<Contacts> listContacts) {

        System.out.println("********** remove contacts *************");
        boolean flag = false;
        int chooseContact;

        if(listContacts.isEmpty()) {
            flag = true;
            System.out.println("the list is empty, there is no possibility of remove contact ... ");
        }

        boolean ifInt;
        while(! flag) { //if false go do it !!!

            printListOfContacts();
            System.out.println("choose contact by number: ");
            ifInt = sc.hasNextInt();

            if(ifInt) {
                chooseContact = sc.nextInt();
                sc.nextLine();
                chooseContact--;
                if(chooseContact > -1 && chooseContact < listContacts.size()) {
                    listContacts.remove(chooseContact);//delete contact
                    setListContacts(listContacts);
                    System.out.println("delete contact ");
                    flag = true;
                } else {
                    System.out.println("wrong number contact ... please again");
                }

            } else {
                System.out.println("wrong contact ... please again");
                sc.nextLine();
            }

        }

    }

    public void searchContact(ArrayList<Contacts> listContacts) {
        System.out.println("********** search contacts **********");
        boolean flag = false;
        int choose;
        boolean ifInt;

        if(listContacts.isEmpty()) {
            flag = true;
            System.out.println("the list is empty, there is no possibility of search contact ... ");
        } else {
            printListOfContacts();
        }

        while(! flag) {
            System.out.println("search by:\n1. name\n2. number phone \n3. exit \n enter the value: ");

            ifInt = sc.hasNextInt();
            if(ifInt) {
                choose = sc.nextInt();
                sc.nextLine();
                switch (choose) {
                    case 1:
                    {
                        findName();
                        break;
                    }
                    case 2:
                    {
                        findNumber();
                        break;
                    }
                    case 3:
                    {
                        flag = true; //return
                        break;
                    }
                    default: {
                        System.out.println("wrong number of range 1 - 3");
                    }
                }
            } else {
                sc.nextLine();
                System.out.println("wrong value ...");
            }

        }

    }

    public void updateExistingContact(ArrayList<Contacts> listContacts) {
        System.out.println("************* modify contacts ***************");

        boolean flag = true, ifInt;
        int chooseContact;

        if(listContacts.isEmpty()) {
            flag = false;
            System.out.println("the list is empty, there is no possibility of modification ... ");
        } else {
            printListOfContacts();
        }

        while (flag) {
            System.out.println("select the contact to modify by number: ");
            ifInt = sc.hasNextInt();

            if( ifInt ) { //if true -> int value !!!

                chooseContact = sc.nextInt();
                sc.nextLine();
                chooseContact--;
                if( chooseContact > -1 && chooseContact < listContacts.size() ) {

                    modifyContact(chooseContact); //change contact
                    flag = false;

                } else {
                    System.out.println("wrong value of contacts ...");
                }


            } else {
                sc.nextLine();
            }

        }

    }
}

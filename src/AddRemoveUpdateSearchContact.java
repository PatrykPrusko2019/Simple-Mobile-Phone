import java.util.ArrayList;

public class AddRemoveUpdateSearchContact extends MobilePhone {



    public void addNewContact(ArrayList<Contacts> listContacts) {
        boolean corectName;
        String name;

        do {
            corectName = true;
            System.out.println("enter the name contact: ");
            name = sc.nextLine();

            if(name.equals("")) { corectName = false; } //no null value of String


        } while ( ! isTrueOfFalse(corectName));//if true -> go out loop

        boolean ifInt;
        do {
            System.out.println("enter the phone number: ");
            ifInt = sc.hasNextLong();
            if(ifInt == false) { sc.nextLine(); }

        } while ( ! isTrueOfFalse(ifInt)); //if true -> go out loop

        long phoneNumber = sc.nextLong();
        sc.nextLine();

        //we check if the contact is repeated
        boolean ifAddContact = onListContactsByName(name, listContacts);

        //if false add new contact
        if( ! ifAddContact) {
            Contacts contacts = new Contacts(name, phoneNumber);
            SaveContacts.addCounter(1);
            listContacts.add(contacts);
            setListContacts(listContacts);
            System.out.println("adding a new contact to the list ");
        }

    }

    public void removeContact(ArrayList<Contacts> listContacts) {

        System.out.println("********** remove contacts *************");
        boolean flag = false;
        int chooseContact;

        if(listContacts.isEmpty()) {
            flag = true;
            System.out.println("the list is empty, there is no possibility of modification ... ");
        }

        boolean ifInt;
        while(! flag) { //if false go work do it !!!

            printListOfContacts();
            System.out.println("choose contact: ");
            ifInt = sc.hasNextInt();

            if(ifInt) {
                chooseContact = sc.nextInt();
                sc.nextLine();

                if(chooseContact > 0 && chooseContact <= listContacts.size()) {
                    listContacts.remove(chooseContact - 1);//delete contact
                    setListContacts(listContacts);
                    System.out.println("delete contact ");
                    SaveContacts.subTractCounter(1);
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
        System.out.println("********* search contacts");
        boolean flag = false;
        int choose;
        boolean ifInt;

        if(listContacts.isEmpty()) {
            flag = true;
            System.out.println("the list is empty, there is no possibility of modification ... ");
        }

        printListOfContacts();

        while(! flag) {
            System.out.println("search by:\n1. name\n2. number \n3. Return\n enter the value: ");

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
                }
            } else {
                sc.nextLine();
            }


        }

    }

    public void updateExistingContact(ArrayList<Contacts> listContacts) {
        System.out.println("************* modify contacts ***************");

        printListOfContacts();
        boolean flag = true, ifInt;
        int chooseContact;

        if(listContacts.isEmpty()) {
            flag = false;
            System.out.println("the list is empty, there is no possibility of modification ... ");
        }

        while (flag) {
            System.out.println("select the contact to modify: ");
            ifInt = sc.hasNextInt();

            if( ifInt ) { //if true -> int value !!!

                chooseContact = sc.nextInt();
                sc.nextLine();

                if( chooseContact > 0 || chooseContact <= listContacts.size() ) {

                    modifyContact(chooseContact-1); //change contact
                    flag = false; //aby wyjsc z petli

                } else {
                    System.out.println("wrong value of contacts ...");
                }


            } else {
                sc.nextLine();
            }

        }

    }
}

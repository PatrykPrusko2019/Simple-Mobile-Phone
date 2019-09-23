import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveContacts {

   private static ArrayList<Contacts> contactsOfList;
   private static int counter = 0;
   private FileWriter writerFile;

   public SaveContacts() {
       try {
           writerFile = new FileWriter("saveContacts.txt");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public static void addCounter(int counter) {
        SaveContacts.counter += counter;
    }

    public static void subTractCounter(int counter) {
        SaveContacts.counter += counter;
    }

   public void finishSaveContacts(ArrayList<Contacts> list) {

       contactsOfList = list;
       int count = 1;
       for(Contacts contact : contactsOfList) {
           try {
               writerFile.write( (count++) + " .Name: " + contact.getName() + ", number phone: " + contact.getNumberPhone() + "\n" );
           } catch (IOException e) {
               e.printStackTrace();
           }
       }


        if(writerFile != null) {
            try {
                writerFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("close to writerFile and save to " + counter + " contacts in file txt");
        }
   }
}

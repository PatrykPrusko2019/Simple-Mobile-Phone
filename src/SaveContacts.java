import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveContacts {

   private ArrayList<Contacts> contactsOfList;
   private int counter = 0;
   private FileWriter writerFile;

   public SaveContacts() {
       try {
               writerFile = new FileWriter("saveContacts.txt");
               writerFile.write("actual list of contacts: \n");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    public void addCounter(int counter) {
        this.counter += counter;
    }


   public void finishSaveContacts(ArrayList<Contacts> list) {

       contactsOfList = list;
       int count = 1;
       for(Contacts contact : contactsOfList) {
           try {
               writerFile.write( (count++) + " .Name: " + contact.getName() + ", number phone: " + contact.getNumberPhone() + "\n" );
               addCounter(1);
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

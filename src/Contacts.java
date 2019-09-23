//name , phone number
public class Contacts extends MobilePhone {

    private String name;
    private long numberPhone;

    public Contacts(String name, long numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(long numberPhone) {
        this.numberPhone = numberPhone;
    }
}

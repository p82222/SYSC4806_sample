package Lab2_ORM;


import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;

    @ManyToOne
    private AddressBook addressbook;

    public BuddyInfo(){

    }

    public BuddyInfo(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public void setAddressBook(AddressBook ab){
        this.addressbook = ab;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

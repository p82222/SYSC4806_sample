package Lab2_ORM;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddyList;



    public AddressBook() {
        buddyList = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy){
        buddyList.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        this.buddyList.remove(buddy);
    }

    public Integer getId() {

        return this.id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public List<BuddyInfo> getBuddyList(){
        return buddyList;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("Mary", "613-555-0000");
        BuddyInfo buddy2 = new BuddyInfo("Andy", "613-999-9998");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        for (BuddyInfo buddy : addressBook.getBuddyList()) {
            System.out.println("Name: " + buddy.getName() + ", Phone Number: " + buddy.getPhone());
        }
    }
}

package Lab2_ORM;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

    @Test
    public void testAddRemoveBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("Chris", "613-222-5555");
        BuddyInfo buddy2 = new BuddyInfo("Mary", "613-000-9999");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        Assert.assertEquals(2, addressBook.getBuddyList().size());

        Assert.assertEquals("Chris", addressBook.getBuddyList().get(0).getName());

        addressBook.removeBuddy(buddy1);

        Assert.assertEquals(1, addressBook.getBuddyList().size());

        Assert.assertEquals("Mary", addressBook.getBuddyList().get(0).getName());
    }




}
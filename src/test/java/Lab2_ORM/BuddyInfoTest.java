package Lab2_ORM;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {

    private static BuddyInfo buddy1;

    @Before
    public void setUp() throws Exception {

        buddy1 = new BuddyInfo("Chiayu", "613-222-0000");


    }



    @Test
    public void getName() {

        Assert.assertEquals("Chiayu", buddy1.getName());
    }

    @Test
    public void getPhone() {

        Assert.assertEquals("613-222-0000", buddy1.getPhone());
    }
}
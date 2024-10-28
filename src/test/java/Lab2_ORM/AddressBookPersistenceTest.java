package Lab2_ORM;

import jakarta.persistence.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AddressBookPersistenceTest {

    @Test
    public void perforAddressPersistenceTest() {

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab2");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        BuddyInfo buddy1 = new BuddyInfo("buddy1", "613-111-1111");

        BuddyInfo buddy2 = new BuddyInfo("buddy2", "613-222-2222");

        AddressBook ab = new AddressBook();

        ab.addBuddy(buddy1);
        ab.addBuddy(buddy2);




        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(ab);

        tx.commit();

        AddressBook resultAddressBook = em.find(AddressBook.class, ab.getId());

        // Querying the contents of the Buddyinfo database
        Assert.assertEquals(2, resultAddressBook.getBuddyList().size());

        System.out.println("Result AddressBook ID: "+ resultAddressBook.getId());

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("List of BuddyInfo\n----------------");

        for (BuddyInfo p : results.get(0).getBuddyList()) {

            System.out.println(p.getName() + " (id= " + p.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();


    }
}

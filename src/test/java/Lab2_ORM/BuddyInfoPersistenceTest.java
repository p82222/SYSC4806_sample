package Lab2_ORM;

import org.junit.Assert;
import org.junit.Test;

import jakarta.persistence.*;
import java.util.List;


public class BuddyInfoPersistenceTest {

    @Test
    public void performBuddyPersistenceTest() {

        BuddyInfo buddy1 = new BuddyInfo("buddy1", "613-111-1111");

        BuddyInfo buddy2 = new BuddyInfo("buddy2", "613-222-2222");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab2");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        tx.commit();

        // Querying the contents of the Buddyinfo database
        BuddyInfo queryBuddy1 = em.find(BuddyInfo.class, buddy1.getId());
        BuddyInfo queryBuddy2 = em.find(BuddyInfo.class, buddy2.getId());

        Assert.assertEquals("buddy1", queryBuddy1.getName());
        Assert.assertEquals("buddy2", queryBuddy2.getName());

        Assert.assertEquals("613-111-1111", queryBuddy1.getPhone());
        Assert.assertEquals("613-222-2222", queryBuddy2.getPhone());

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of BuddyInfo\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(p.getName() + " (id=" + p.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();


    }
}

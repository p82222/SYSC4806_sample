package Lab2_ORM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    /*

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Bean
    public CommandLineRunner AddressBookdemo(AddressBookRepository book, BuddyInfoRepository buddy) {

        return (args) -> {
            // save a few customers
            buddy.save(new BuddyInfo("Buddy1","111-1111"));
            buddy.save(new BuddyInfo("Buddy2","222-2222"));
            buddy.save(new BuddyInfo("Buddy3","333-3333"));

            AddressBook addressbook = new AddressBook();

            addressbook.addBuddy(new BuddyInfo("name1", "123"));

            book.save(addressbook);

            log.info(addressbook.getBuddyList().toString());



            // fetch all customers
            log.info("Buddy found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo b : buddy.findAll()) {
                log.info(b.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo customer = buddy.findById(1);
            log.info("Buddy found with findById(1):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Buddy found with findByName('Buddy2'):");
            log.info("--------------------------------------------");
            buddy.findByName("Buddy2").forEach(buddy2 -> {
                log.info(buddy2.toString());
            });





        };

    }

     */


}

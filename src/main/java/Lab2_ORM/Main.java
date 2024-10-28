package Lab2_ORM;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("Mary", "613-555-0000");
        BuddyInfo buddy2 = new BuddyInfo("Andy", "613-999-9998");

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);


        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        System.out.println();

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (BuddyInfo buddy : addressBook.getBuddyList()) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("Name: " + buddy.getName() + ", Phone Number: " + buddy.getPhone());

        }
    }
}
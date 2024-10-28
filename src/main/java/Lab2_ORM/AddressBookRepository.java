package Lab2_ORM;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    @Query("SELECT DISTINCT ab FROM AddressBook ab LEFT JOIN FETCH ab.buddyList where ab.id = :addressBookId")
    AddressBook findByIdwithBuddyInfo(@Param("id") long addressBookId);
}
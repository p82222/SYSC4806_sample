package Lab2_ORM;

import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buddies")
public class BuddyIndoController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;
    @Autowired
    private AddressBookRepository addressBookRepository;

    public BuddyIndoController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository){

        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;

    }

    // Get all buddies
    @GetMapping
    public List<BuddyInfo> getBuddies(){
        return (List<BuddyInfo>) buddyInfoRepository.findAll();
    }

    @PostMapping
    @ResponseBody
    public BuddyInfo addBuddy(@RequestBody BuddyInfo buddyInfo, @RequestParam Long addressBookId){
        AddressBook ad = addressBookRepository.findById(addressBookId)
                .orElseThrow(()-> new IllegalArgumentException("Invalid AddressBook Id") );

        ad.addBuddy(buddyInfo);//add buddyinfo in the addressbook

        addressBookRepository.save(ad); //save the updated addressbook

        //buddyInfo.setId(addressBookId);

        // Let the repository generate the ID
        return buddyInfoRepository.save(buddyInfo); //save the buddyinfo and return


    }

    @GetMapping("/addressBook")
    public List<BuddyInfo> getBuddiesByAddressBookId(@RequestParam Long addressBookId) {
        AddressBook ad = addressBookRepository.findById(addressBookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid AddressBook Id"));

        return ad.getBuddyList(); // Assuming you have a method to get buddies from AddressBook
    }


//    @DeleteMapping("/{addressID}/buddies/{buddyId}")
//    public void deleteBuddyInfo(@PathVariable Long addressID, @PathVariable Long buddyId) {
//        Optional<AddressBook> addressBookOptional = addressBookRepository.findById(addressID);
//        Optional<BuddyInfo> buddyInfoOptional = buddyInfoRepository.findById(buddyId);
//
//        // Check if both the address book and buddy exist
//        if (addressBookOptional.isPresent() && buddyInfoOptional.isPresent()) {
//            AddressBook ad = addressBookOptional.get();
//            BuddyInfo buddy = buddyInfoOptional.get();
//
//            // Remove the buddy from the address book
//            ad.removeBuddy(buddy);
//            addressBookRepository.save(ad); // Save updated address book
//        } else {
//            throw new IllegalArgumentException("Invalid AddressBook ID or BuddyInfo ID");
//        }
//    }
@DeleteMapping("/{addressID}/buddies/{buddyId}")
public ResponseEntity<Void> deleteBuddyInfo(@PathVariable Long addressID, @PathVariable Long buddyId) {
    System.out.println("DELETE Request received for AddressBook ID: " + addressID + " and Buddy ID: " + buddyId);

    // Find the AddressBook
    Optional<AddressBook> addressBookOptional = addressBookRepository.findById(addressID);
    if (!addressBookOptional.isPresent()) {
        System.out.println("AddressBook not found for ID: " + addressID);
        return ResponseEntity.notFound().build(); // Return 404 if AddressBook not found
    }

    // Find the BuddyInfo
    Optional<BuddyInfo> buddyInfoOptional = buddyInfoRepository.findById(buddyId);
    if (!buddyInfoOptional.isPresent()) {
        System.out.println("BuddyInfo not found for ID: " + buddyId);
        return ResponseEntity.notFound().build(); // Return 404 if BuddyInfo not found
    }

    // Remove the buddy from the address book
    AddressBook addressBook = addressBookOptional.get();
    BuddyInfo buddy = buddyInfoOptional.get();
    System.out.println("Removing Buddy with ID: " + buddyId + " from AddressBook with ID: " + addressID);
    addressBook.removeBuddy(buddy);
    addressBookRepository.save(addressBook); // Save the updated address book
    buddyInfoRepository.delete(buddy); // Delete the buddy

    System.out.println("Buddy with ID " + buddyId + " deleted from AddressBook " + addressID);
    return ResponseEntity.noContent().build(); // Return 204 No Content on successful delete
}




}

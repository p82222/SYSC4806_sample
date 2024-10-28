package Lab2_ORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@RequestMapping("/addressbooks")
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping
    public List<AddressBook> getAddressBooks(){
        return (List<AddressBook>) addressBookRepository.findAll();
    }

    @GetMapping("/{id}")
    public AddressBook getAddressBook(@PathVariable Long id){
        return addressBookRepository.findByIdwithBuddyInfo(id);
    }

    /*
    @GetMapping("/{id}/buddies")
    public String displayBuddyList(@PathVariable Long id){
        AddressBook ab = addressBookRepository.findByIdwithBuddyInfo(id);
        model.addAttribute("buddyList",ab.getBuddyList());
        return "buddyList";
    }
    */


    @GetMapping("/{id}/buddies")
    public List<BuddyInfo> getBuddiesByAddressBook(@PathVariable Long id) {
        AddressBook ab = addressBookRepository.findByIdwithBuddyInfo(id);
        return ab.getBuddyList(); // Assuming getBuddyList returns a List<BuddyInfo>
    }

    @PostMapping
    @ResponseBody
    public AddressBook addAddressBook(){
        AddressBook ab = new AddressBook();
        return addressBookRepository.save(ab);
    }

    @PostMapping("/{id}/buddies")
    public BuddyInfo addBuddyToAddressBook(@PathVariable Long id, @RequestBody BuddyInfo buddyInfo) {
        AddressBook ab = addressBookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid AddressBook ID"));

        ab.addBuddy(buddyInfo); // Assuming you have a method to add a buddy
        addressBookRepository.save(ab);

        return buddyInfoRepository.save(buddyInfo); // Save and return the BuddyInfo
    }

    @DeleteMapping("/{id}")
    public void deleteAddressBook(@PathVariable Long id){
        addressBookRepository.deleteById(id);
    }
}

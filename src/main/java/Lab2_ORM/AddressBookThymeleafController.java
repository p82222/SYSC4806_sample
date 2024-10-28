package Lab2_ORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class AddressBookThymeleafController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressbook/{id}/buddies")
    public String displayBuddyList(@PathVariable Long id, Model model){
        AddressBook ab = addressBookRepository.findByIdwithBuddyInfo(id);
        model.addAttribute("buddyList",ab.getBuddyList());
        return "buddyList"; // Return the Thymeleaf template name
    }


}

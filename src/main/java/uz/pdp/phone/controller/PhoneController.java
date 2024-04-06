package uz.pdp.phone.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.phone.model.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PhoneController {

    List<Phone>phones=new ArrayList<>(Arrays.asList(
            new Phone(1,"IPhone","36-DD-36-FF",1234567),
            new Phone(2,"Samsung","37-DD-37-FF",1234568),
            new Phone(3,"Nokia","38-DD-38-FF",1234569),
            new Phone(4,"ReadMe","39-DD-39-FF",1234560)
    ));

    @RequestMapping(value = "/phone",method = RequestMethod.GET)
    public List<Phone>getPhones(){
        return phones;
    }

    //get  one Phone by id
    @RequestMapping(value = "/phone/{id}",method = RequestMethod.GET)
    public Phone getPhoneById(@PathVariable Integer id){
        for (Phone phone : phones) {
            if (phone.getId()==id){
              return phone;
            }
        }
        return null;
    }

     //add new phone
    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String addPhone(@RequestBody Phone phone){
        boolean isThere =false;
        for (Phone phone1 : phones) {
            if (phone1.getMacAddress().equals(phone.getMacAddress())){
                isThere=true;
                break;
            }
        }
        if (isThere){
            return "product not added";
        }else {
            phone.setId(phones.get(phones.size()-1).getId()+1);
            phones.add(phone);
            return "product added";
        }    }

//      delete
    @RequestMapping(value = "/phone/{id}",method = RequestMethod.DELETE)
    public String deletePhone(@PathVariable Integer id){
        boolean deleted=false;
        for (Phone phone : phones) {
            if (phone.getId().equals(id)){
                phones.remove(phone);
                deleted=true;
                break;
    }   }
        return deleted? "Phone deleted":"Phone not found";
    }

// update
     @RequestMapping(value ="/phone/{id}",method = RequestMethod.PUT)
     public String editPhone(@PathVariable Integer id, @RequestBody Phone phone){
        boolean edited=false;
        for (Phone currentPhone : phones) {
            if (currentPhone.getId().equals(id)){
            currentPhone.setModel(phone.getModel());
            currentPhone.setMacAddress(phone.getMacAddress());
            currentPhone.setPhoneNumber(phone.getPhoneNumber());
            edited=true;
            break;
         }
      } return edited ? "Phone edited" : "Phone not found";


}
}









package hello.Controller;

import hello.Domain.Contact;
import hello.Repository.contactRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/AgendaTelefonica")
public class ControllerContact {
    @Autowired
    private contactRepository contactRepository;


    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> findAll() {
        List<Contact> list = contactRepository.findAll();
        JSONObject object = new JSONObject();
        object.put("contact", list);
        return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/detaliicontact/{id_contact}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getDetalii(@PathVariable Integer id_contact) {
        Contact contact =  contactRepository.findOne(id_contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);    }

}

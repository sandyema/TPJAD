package hello.Controller;

import hello.Domain.Contact;
import hello.Domain.ContactInterfata;
import hello.Repository.contactRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
        list.sort((s1,s2)->s1.getContactNume().compareTo(s2.getContactNume()));
        JSONObject object = new JSONObject();
        object.put("contact", list);
        return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/detaliicontact/{id_contact}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getDetalii(@PathVariable Integer id_contact) {
        Contact contact =  contactRepository.findOne(id_contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);    }


    @ResponseBody
    @RequestMapping(value = "/searchContacte/{nume}", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> searchgTichete(@PathVariable String nume) {
        List<ContactInterfata> listaContacte =new ArrayList<>();
        JSONObject object=new JSONObject();

        Integer id_contact=0;
        for (Contact contact : contactRepository.findAll()) {
            id_contact=contact.getContactId();
                    if (contact.getContactNume().contains(nume) ) {


                        ContactInterfata contactInterfata=new ContactInterfata(id_contact,contact.getContactNume());
                        listaContacte.add(contactInterfata);
                    }


        }
        object.put("DataObject",listaContacte);
        return new ResponseEntity<JSONObject>(object, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject deleteContact(@RequestBody JSONObject contact) {
        System.out.println("Try to delete contact  :" + contact.getAsString("contactId"));
        Integer contactID = Integer.valueOf(contact.getAsString("contactId"));
        Boolean deleted = false;
        HashMap<String, String> response = new HashMap<String, String>();

        ArrayList<Contact> contacts = (ArrayList<Contact>) contactRepository.findAll();
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactID)) {
                contactRepository.delete(c);
                deleted = true;
                break;
            }
        }
        if (deleted) {
            response.put("response", "true");
            System.out.println("Succes to delete for " + contact.getAsString("contactId"));
        } else {
            response.put("response", "false");
            System.out.println("Error to delete for " + contact.getAsString("contactId"));
        }
        return new JSONObject(response);
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public @ResponseBody
    JSONObject addContact(@RequestBody JSONObject contact) {
        System.out.println("Try to add contact  :" + contact.getAsString("contactNume"));
        HashMap<String, String> response = new HashMap<String, String>();


        String contactNume = contact.getAsString("contactNume");
        String contactEmail = contact.getAsString("contactEmail");
        String numartelefon1 = contact.getAsString("numartelefon1");
        String numartelefon2 = contact.getAsString("numartelefon2");
        String ziNastere = contact.getAsString("ziNastere");


        Contact contact_added = contactRepository.save(new Contact(contactNume,contactEmail,numartelefon1,numartelefon2,ziNastere));


        if (contact_added != null) {
            response.put("response", "true");
            System.out.println("Succes to add for " + contactNume );

        } else {
            response.put("response", "false");
            System.out.println("Error to add for " + contactNume);
            System.out.println(contact_added);
        }

        return new JSONObject(response);
    }
}

package hello.Domain;

import java.io.Serializable;

public class ContactInterfata implements Serializable {

    Integer contactId;
    String contactNume;
    String poza;
    public ContactInterfata() {
    }

    public ContactInterfata(Integer contactId, String contactNume) {
        this.contactId = contactId;
        this.contactNume = contactNume;
    }

    public ContactInterfata(Integer contactId, String contactNume, String poza) {
        this.contactId = contactId;
        this.contactNume = contactNume;
        this.poza = poza;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactNume() {
        return contactNume;
    }

    public void setContactNume(String contactNume) {
        this.contactNume = contactNume;
    }

    public String getPoza() {
        return poza;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }
}

package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.common.domain.Address;
import br.com.uol.pagseguro.api.common.domain.Phone;
import br.com.uol.pagseguro.api.common.domain.xml.AddressXML;
import br.com.uol.pagseguro.api.common.domain.xml.PhoneXML;
import br.com.uol.pagseguro.api.utils.XMLUnmarshallListener;

import javax.xml.bind.annotation.XmlElement;

/**
 * Implementation of {@code PreApprovalSubscriptionSender}
 *
 * @author PagSeguro Internet Ltda.
 */
public class PreApprovalSubscriptionSenderXML implements PreApprovalSubscriptionSender, XMLUnmarshallListener {
    private PagSeguro pagSeguro;

    private String name;
    private String email;
    private PhoneXML phone;
    private AddressXML address;

    @Override
    public String getName() {
        return this.name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Phone getPhone() {
        return this.phone;
    }

    @XmlElement
    public void setPhone(PhoneXML phone) {
        this.phone = phone;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @XmlElement
    public void setAddress(AddressXML address) {
        this.address = address;
    }

    @Override
    public void onUnmarshal(PagSeguro pagseguroAPI, String rawData) {
        this.pagSeguro = pagseguroAPI;
    }

    public String toString() {
        return "PreApprovalSubscriptionSenderXML{" +
                "name='" + name + "'" +
                "email='" + email + "'" +
                "phone='" + phone + "'" +
                "address='" + address + "'" +
                '}';
    }
}

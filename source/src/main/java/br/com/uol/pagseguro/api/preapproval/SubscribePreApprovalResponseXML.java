package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.utils.XMLUnmarshallListener;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation of {@code SubscribedPreApproval} and {@code XMLUnmarshallListener}
 *
 * @author Yehoshua Oliveira
 */
@XmlRootElement(name = "directPreApproval")
public class SubscribePreApprovalResponseXML implements SubscribedPreApproval, XMLUnmarshallListener {

    private PagSeguro pagSeguro;

    private String code;

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void onUnmarshal(PagSeguro pagSeguro, String rawData) {
        this.pagSeguro = pagSeguro;
    }

    @Override
    public String toString() {
        return "SubscribePreApprovalResponseXML{" +
                "pagSeguro=" + pagSeguro +
                ", code='" + code + '\'' +
                '}';
    }
}

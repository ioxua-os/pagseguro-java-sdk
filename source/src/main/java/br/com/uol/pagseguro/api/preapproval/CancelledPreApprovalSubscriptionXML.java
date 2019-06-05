package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.utils.XMLUnmarshallListener;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation of {@code CancelledPreApprovalSubscription} and {@code XMLUnmarshallListener}
 *
 * @author Yehoshua Oliveira
 */
@XmlRootElement(name = "cancelledPreApprovalSubscription")
public class CancelledPreApprovalSubscriptionXML implements CancelledPreApprovalSubscription, XMLUnmarshallListener {

    private PagSeguro pagSeguro;

    @Override
    public void onUnmarshal(PagSeguro pagseguro, String rawData) {
        this.pagSeguro = pagseguro;
    }

    @Override
    public String toString() {
        return "CancelledPreApprovalSubscriptionXML{" +
                "  pagSeguro=" + pagSeguro +
                '}';
    }
}

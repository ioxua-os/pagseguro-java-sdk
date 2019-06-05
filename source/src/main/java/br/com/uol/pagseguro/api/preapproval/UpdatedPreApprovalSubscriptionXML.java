package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.utils.XMLUnmarshallListener;

public class UpdatedPreApprovalSubscriptionXML implements UpdatedPreApprovalSubscription, XMLUnmarshallListener {

    private PagSeguro pagSeguro;

    @Override
    public void onUnmarshal(PagSeguro pagseguro, String rawData) {
        this.pagSeguro = pagseguro;
    }

    @Override
    public String toString() {
        return "UpdatedPreApprovalSubscriptionXML{" +
                "  pagSeguro=" + pagSeguro +
                '}';
    }
}

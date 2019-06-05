package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.converter.SenderJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractMapConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;

/**
 * Converter for Pre Approval Subscription
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSubscriptionMapConverter extends
        AbstractJsonConverter<PreApprovalSubscription> {

    private final static SenderJsonConverter SENDER_MC = new SenderJsonConverter();
    private final static PreApprovalPaymentMethodJsonConverter PAYMENT_METHOD_MC =
            new PreApprovalPaymentMethodJsonConverter();

    PreApprovalSubscriptionMapConverter() {}

    /**
     * Convert Interface for Pre Approval Subscription in Request Map
     *
     * @param requestJson          Request Json used to pass params to api
     * @param preApprovalSubscription Interface for Pre Approval Subscription
     * @see RequestJson
     * @see PreApprovalSubscription
     * @see AbstractMapConverter#convert(Object)
     */
    @Override
    protected void convert(RequestJson requestJson, PreApprovalSubscription preApprovalSubscription) {
        requestJson.putString("reference", preApprovalSubscription.getReference());
        requestJson.putString("redirectURL", preApprovalSubscription.getRedirectURL());
        requestJson.putJson(SENDER_MC.convert(preApprovalSubscription.getSender()), "sender");
        requestJson.putJson(PAYMENT_METHOD_MC.convert(preApprovalSubscription.getPreApprovalPaymentMethod()), "paymentMethod");
    }
}

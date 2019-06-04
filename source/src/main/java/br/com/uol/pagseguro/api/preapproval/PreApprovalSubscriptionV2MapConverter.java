package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.converter.SenderV2MapConverter;
import br.com.uol.pagseguro.api.utils.AbstractMapConverter;
import br.com.uol.pagseguro.api.utils.RequestMap;

/**
 * Converter for V2 Pre Approval Subscription
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSubscriptionV2MapConverter extends
        AbstractMapConverter<PreApprovalSubscription> {

    private final static SenderV2MapConverter SENDER_MC = new SenderV2MapConverter();
    private final static PreApprovalPaymentMethodV2MapConverter PAYMENT_METHOD_MC =
            new PreApprovalPaymentMethodV2MapConverter();

    PreApprovalSubscriptionV2MapConverter() {}

    /**
     * Convert Interface for Pre Approval Subscription in Request Map
     *
     * @param requestMap          Request Map used to pass params to api
     * @param preApprovalSubscription Interface for Pre Approval Subscription
     * @see RequestMap
     * @see PreApprovalSubscription
     * @see AbstractMapConverter#convert(Object)
     */
    @Override
    protected void convert(RequestMap requestMap, PreApprovalSubscription preApprovalSubscription) {
        requestMap.putString("reference", preApprovalSubscription.getReference());
        requestMap.putString("redirectURL", preApprovalSubscription.getRedirectURL());
        requestMap.putMap(SENDER_MC.convert(preApprovalSubscription.getSender()));
        requestMap.putMap(PAYMENT_METHOD_MC.convert(preApprovalSubscription.getPreApprovalPaymentMethod()));
    }
}

package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethodV2;
import br.com.uol.pagseguro.api.common.domain.converter.CreditCardV2MapConverter;
import br.com.uol.pagseguro.api.utils.AbstractMapConverter;
import br.com.uol.pagseguro.api.utils.RequestMap;

/**
 * Converter for V2 Pre Approval Subscription
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalPaymentMethodV2MapConverter extends
        AbstractMapConverter<PreApprovalPaymentMethodV2> {

    private static final CreditCardV2MapConverter CREDIT_CARD_MC = new CreditCardV2MapConverter();

    PreApprovalPaymentMethodV2MapConverter() {}

    /**
     * Convert Interface for Pre Approval Subscription in Request Map
     *
     * @param requestMap              Request Map used to pass params to api
     * @param preApprovalPaymentMethod Interface for Pre Approval Subscription
     * @see RequestMap
     * @see PreApprovalPaymentMethodV2
     * @see AbstractMapConverter#convert(Object)
     */
    @Override
    protected void convert(RequestMap requestMap, PreApprovalPaymentMethodV2 preApprovalPaymentMethod) {
        requestMap.putString("type", preApprovalPaymentMethod.getType());
        requestMap.putMap(CREDIT_CARD_MC.convert(preApprovalPaymentMethod.getCreditCard()));
    }
}

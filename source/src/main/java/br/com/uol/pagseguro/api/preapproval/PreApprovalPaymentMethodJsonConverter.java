package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethod;
import br.com.uol.pagseguro.api.common.domain.converter.PreApprovalCreditCardJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractMapConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;

/**
 * Converter for Pre Approval Subscription
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalPaymentMethodJsonConverter extends AbstractJsonConverter<PreApprovalPaymentMethod> {
    private static final PreApprovalCreditCardJsonConverter CREDIT_CARD_MC = new PreApprovalCreditCardJsonConverter();

    PreApprovalPaymentMethodJsonConverter() {}

    /**
     * Convert Interface for Pre Approval Subscription in Request Map
     *
     * @param requestJson              Request Json used to pass params to api
     * @param preApprovalPaymentMethod Interface for Pre Approval Subscription
     * @see RequestJson
     * @see PreApprovalPaymentMethod
     * @see AbstractMapConverter#convert(Object)
     */
    @Override
    protected void convert(RequestJson requestJson, PreApprovalPaymentMethod preApprovalPaymentMethod) {
        requestJson.putString("type", preApprovalPaymentMethod.getType());
        requestJson.putJson(CREDIT_CARD_MC.convert(preApprovalPaymentMethod.getPreApprovalCreditCard()), "creditCard");
    }
}

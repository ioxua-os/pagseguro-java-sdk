package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.converter.AbstractPreApprovalCreditCardJsonConverter;
import br.com.uol.pagseguro.api.common.domain.converter.PreApprovalSenderJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;

/**
 * Converter for Pre Approval Subscription payment method updates
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSubscriptionPaymentMethodUpdateJsonConverter
        extends AbstractJsonConverter<PreApprovalSubscriptionPaymentMethodUpdate> {

    private final static PreApprovalSenderJsonConverter SENDER_MC = new PreApprovalSenderJsonConverter();
    private final static PreApprovalCreditCardJsonConverter CREDIT_CARD_MC =
            new PreApprovalCreditCardJsonConverter();

    PreApprovalSubscriptionPaymentMethodUpdateJsonConverter() {}

    @Override
    protected void convert(RequestJson requestJson, PreApprovalSubscriptionPaymentMethodUpdate preApprovalUpdate) {
        requestJson.putString("type", preApprovalUpdate.getType());
        requestJson.putJson(CREDIT_CARD_MC.convert(preApprovalUpdate.getCreditCard()), "creditCard");
        requestJson.putJson(SENDER_MC.convert(preApprovalUpdate.getSender()), "sender");
    }

    private static class PreApprovalCreditCardJsonConverter extends AbstractPreApprovalCreditCardJsonConverter {
        @Override
        protected String getTokenKey() {
            return "token";
        }

        @Override
        protected String getPreApprovalHolderKey() {
            return "holder";
        }
    }
}

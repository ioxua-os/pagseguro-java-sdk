package br.com.uol.pagseguro.api.common.domain.converter;

import br.com.uol.pagseguro.api.common.domain.PreApprovalCreditCard;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;

/**
 * Converter for credit card. Used in version 1 of the application
 * Used to convert attributes of pre approval credit cards to request maps.
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalCreditCardJsonConverter extends AbstractJsonConverter<PreApprovalCreditCard> {
    private final static PreApprovalHolderJsonConverter HOLDER_MC = new PreApprovalHolderJsonConverter();

    @Override
    protected void convert(RequestJson requestJson, PreApprovalCreditCard creditCard) {
        requestJson.putString("token", creditCard.getToken());
        requestJson.putJson(HOLDER_MC.convert(creditCard.getHolder()), "holder");
    }

    private static class PreApprovalHolderJsonConverter extends AbstractPreApprovalHolderJsonConverter {
        @Override
        protected String getNameKey() {
            return "name";
        }

        @Override
        protected String getBirthDateKey() {
            return "birthDate";
        }

        @Override
        protected String getDocumentsKey() {
            return "documents";
        }

        @Override
        protected String getPhoneKey() {
            return "phone";
        }

        @Override
        protected String getBillingAddressKey() {
            return "billingAddress";
        }
    }
}

package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.common.domain.converter.AbstractDocumentJsonConverter;
import br.com.uol.pagseguro.api.common.domain.converter.AbstractPhoneJsonConverter;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

public class BoletoRegistrarionJsonConverter extends AbstractJsonConverter<BoletoRegistration> {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final BoletoCustomerJsonConverter BOLETO_CUSTOMER_JSON_CONVERTER =
            new BoletoCustomerJsonConverter();

    private final static BoletoCustomerDocumentJsonConverter BOLETO_CUSTOMER_DOCUMENT_JSON_CONVERTER =
            new BoletoCustomerDocumentJsonConverter();

    private final static BoletoCustomerPhoneJsonConverter BOLETO_CUSTOMER_PHONE_JSON_CONVERTER =
            new BoletoCustomerPhoneJsonConverter();

    @Override
    protected void convert(RequestJson requestJson, BoletoRegistration boletoRegistration) {
        if (null != boletoRegistration.getPeriodicity()) {
            requestJson.putString("periodicity", boletoRegistration.getPeriodicity().name().toLowerCase());
        }

        requestJson.putDate("firstDueDate", boletoRegistration.getFirstDueDate(), SIMPLE_DATE_FORMAT);
        requestJson.putInteger("numberOfPayments", boletoRegistration.getNumberOfPayments());
        requestJson.putCurrency("amount", boletoRegistration.getAmount());
        requestJson.putString("description", boletoRegistration.getDescription());

        if (null != boletoRegistration.getCustomer()) {
            requestJson.putJson(BOLETO_CUSTOMER_JSON_CONVERTER.convert(
                    boletoRegistration.getCustomer()), "customer");
        }
    }

    private static class BoletoCustomerJsonConverter extends AbstractJsonConverter<BoletoCustomer> {
        @Override
        protected void convert(RequestJson requestJson, BoletoCustomer customer) {
            requestJson.putString("name", customer.getName());
            requestJson.putString("email", customer.getEmail());
            requestJson.putJson(BOLETO_CUSTOMER_DOCUMENT_JSON_CONVERTER.convert(
                    Collections.singletonList(customer.getDocument())), "document");
            requestJson.putJson(BOLETO_CUSTOMER_PHONE_JSON_CONVERTER.convert(
                    customer.getPhone()), "phone");
        }
    }

    private static class BoletoCustomerDocumentJsonConverter extends AbstractDocumentJsonConverter {
        @Override
        protected String getTypeKey() {
            return "type";
        }

        @Override
        protected String getValueKey() {
            return "value";
        }
    }

    private static class BoletoCustomerPhoneJsonConverter extends AbstractPhoneJsonConverter {
        @Override
        protected String getAreaCodeKey() {
            return "areaCode";
        }

        @Override
        protected String getPhoneNumberKey() {
            return "number";
        }
    }

}

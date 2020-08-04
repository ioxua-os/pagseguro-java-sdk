package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.common.domain.Document;
import br.com.uol.pagseguro.api.common.domain.Phone;
import br.com.uol.pagseguro.api.utils.Builder;

public class BoletoCustomerBuilder implements Builder<BoletoCustomer> {

    private Document document;
    private String name;
    private String email;
    private Phone phone;

    // **************************************************************************

    public Document getDocument() {
        return document;
    }

    public BoletoCustomerBuilder withDocument(Document document) {
        this.document = document;
        return this;
    }

    public String getName() {
        return name;
    }

    public BoletoCustomerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BoletoCustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public Phone getPhone() {
        return phone;
    }

    public BoletoCustomerBuilder withPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    // **************************************************************************

    @Override
    public BoletoCustomer build() {
        return null;
    }

    // **************************************************************************

    private static class SimpleBoletoCustomer implements BoletoCustomer {

        private final BoletoCustomerBuilder builder;

        public SimpleBoletoCustomer(BoletoCustomerBuilder builder) {
            this.builder = builder;
        }

        @Override
        public Document getDocument() {
            return builder.document;
        }

        @Override
        public String getName() {
            return builder.name;
        }

        @Override
        public String getEmail() {
            return builder.email;
        }

        @Override
        public Phone getPhone() {
            return builder.phone;
        }
    }
}

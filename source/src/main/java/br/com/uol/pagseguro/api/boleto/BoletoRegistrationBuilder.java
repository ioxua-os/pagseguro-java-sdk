package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.utils.Builder;

import java.math.BigDecimal;
import java.util.Date;

public class BoletoRegistrationBuilder implements Builder<BoletoRegistration> {

    private BoletoRegistrationPeriodicity periodicity;
    private Date firstDueDate;
    private Integer numberOfPayments;
    private BigDecimal amount;
    private String description;
    private BoletoCustomer customer;

    // **************************************************************************

    public BoletoRegistrationPeriodicity getPeriodicity() {
        return periodicity;
    }

    public BoletoRegistrationBuilder withPeriodicity(BoletoRegistrationPeriodicity periodicity) {
        this.periodicity = periodicity;
        return this;
    }

    public Date getFirstDueDate() {
        return firstDueDate;
    }

    public BoletoRegistrationBuilder withFirstDueDate(Date firstDueDate) {
        this.firstDueDate = firstDueDate;
        return this;
    }

    public Integer getNumberOfPayments() {
        return numberOfPayments;
    }

    public BoletoRegistrationBuilder withNumberOfPayments(Integer numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BoletoRegistrationBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BoletoRegistrationBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public BoletoCustomer getCustomer() {
        return customer;
    }

    public BoletoRegistrationBuilder withCustomer(BoletoCustomer customer) {
        this.customer = customer;
        return this;
    }

    // **************************************************************************

    @Override
    public BoletoRegistration build() {
        return new SimpleBoletoRegistrarion(this);
    }

    // **************************************************************************

    private static class SimpleBoletoRegistrarion implements BoletoRegistration {

        private final BoletoRegistrationBuilder builder;

        SimpleBoletoRegistrarion(BoletoRegistrationBuilder builder) {
            this.builder = builder;
        }

        @Override
        public BoletoRegistrationPeriodicity getPeriodicity() {
            return builder.periodicity;
        }

        @Override
        public Date getFirstDueDate() {
            return builder.firstDueDate;
        }

        @Override
        public Integer getNumberOfPayments() {
            return builder.numberOfPayments;
        }

        @Override
        public BigDecimal getAmount() {
            return builder.amount;
        }

        @Override
        public String getDescription() {
            return builder.description;
        }

        @Override
        public BoletoCustomer getCustomer() {
            return builder.customer;
        }
    }
}

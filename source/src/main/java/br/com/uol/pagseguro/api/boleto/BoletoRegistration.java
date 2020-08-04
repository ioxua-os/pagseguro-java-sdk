package br.com.uol.pagseguro.api.boleto;

import java.math.BigDecimal;
import java.util.Date;

public interface BoletoRegistration {

    BoletoRegistrationPeriodicity getPeriodicity();
    Date getFirstDueDate();
    Integer getNumberOfPayments();
    BigDecimal getAmount();
    String getDescription();
    BoletoCustomer getCustomer();

}

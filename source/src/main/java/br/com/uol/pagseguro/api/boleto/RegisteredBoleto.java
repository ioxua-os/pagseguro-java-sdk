package br.com.uol.pagseguro.api.boleto;

import java.time.LocalDate;

public interface RegisteredBoleto {
    String getCode();
    String getPaymentLink();
    String getBarcode();
    LocalDate getDueDate();
}

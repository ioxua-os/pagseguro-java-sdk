package br.com.uol.pagseguro.api.boleto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class RegisteredBoletosResponseJSON implements RegisteredBoletos {

    private List<RegisteredBoletoJSON> boletos;

    @Override
    public List<RegisteredBoletoJSON> getBoletos() {
        return boletos;
    }

    public static class RegisteredBoletoJSON implements RegisteredBoleto {
        private String code;
        private String paymentLink;
        private String barcode;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate dueDate;

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getPaymentLink() {
            return paymentLink;
        }

        @Override
        public String getBarcode() {
            return barcode;
        }

        @Override
        public LocalDate getDueDate() {
            return dueDate;
        }
    }
}

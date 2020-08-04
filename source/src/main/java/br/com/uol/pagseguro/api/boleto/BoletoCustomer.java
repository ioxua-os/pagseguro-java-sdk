package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.common.domain.Document;
import br.com.uol.pagseguro.api.common.domain.Phone;

public interface BoletoCustomer {
    Document getDocument();
    String getName();
    String getEmail();
    Phone getPhone();
}

package br.com.uol.pagseguro.api.boleto;

import java.util.List;

public interface RegisteredBoletos {
    List<? extends RegisteredBoleto> getBoletos();
}

package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.Endpoints;
import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.checkout.RegisteredCheckout;
import br.com.uol.pagseguro.api.exception.PagSeguroLibException;
import br.com.uol.pagseguro.api.http.HttpClient;
import br.com.uol.pagseguro.api.http.HttpMethod;
import br.com.uol.pagseguro.api.http.HttpResponse;
import br.com.uol.pagseguro.api.utils.Builder;
import br.com.uol.pagseguro.api.utils.CharSet;
import br.com.uol.pagseguro.api.utils.RequestJson;
import br.com.uol.pagseguro.api.utils.logging.Log;
import br.com.uol.pagseguro.api.utils.logging.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoletoResource {

    private static final BoletoRegistrarionJsonConverter BOLETO_REGISTRARION_JSON_CONVERTER =
            new BoletoRegistrarionJsonConverter();

    private static final Log LOGGER = LoggerFactory.getLogger(BoletoResource.class.getName());

    private final PagSeguro pagSeguro;
    private final HttpClient httpClient;

    public BoletoResource(PagSeguro pagSeguroAPI, HttpClient httpClient) {
        this.pagSeguro = pagSeguroAPI;
        this.httpClient = httpClient;
    }

    /**
     * Boleto Registration
     *
     * @param boletoRegistrationBuilder Builder for Interface with attributes for boleto
     * @return Response of boleto registration
     * @see RegisteredCheckout
     * @see BoletoRegistration
     */
    public RegisteredBoletos register(Builder<BoletoRegistration> boletoRegistrationBuilder) {
        return register(boletoRegistrationBuilder.build());
    }

    /**
     * Boleto Registration
     *
     * @param boletoRegistration Interface with attributes for boleto
     * @return Response of boleto registration
     * @see RegisteredBoletos
     * @see BoletoRegistration
     */
    public RegisteredBoletos register(BoletoRegistration boletoRegistration) {
        LOGGER.info("Iniciando checkout");
        LOGGER.info("Convertendo valores");
        final RequestJson json = BOLETO_REGISTRARION_JSON_CONVERTER.convert(boletoRegistration);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=ISO-8859-1");
        headers.put("Accept", "application/json;charset=ISO-8859-1");

        LOGGER.info("Valores convertidos");
        final HttpResponse response;
        try {
            LOGGER.debug(String.format("Parametros: %s", json));
            response = httpClient.executeJson(HttpMethod.POST, String.format(Endpoints.REGISTER_BOLETO,
                    pagSeguro.getHost()), headers, json.toHttpJsonRequestBody(CharSet.ENCODING_ISO));
            LOGGER.debug(String.format("Resposta: %s", response.toString()));
        } catch (IOException e) {
            LOGGER.error("Erro ao executar boletos");
            throw new PagSeguroLibException(e);
        }
        LOGGER.info("Parseando JSON de resposta");
        RegisteredBoletosResponseJSON registeredBoletosResponseJSON = response.parseJSONContent(
                RegisteredBoletosResponseJSON.class);
        LOGGER.info("Parseamento finalizado");
        LOGGER.info("Boleto finalizado");
        return registeredBoletosResponseJSON;
    }
}

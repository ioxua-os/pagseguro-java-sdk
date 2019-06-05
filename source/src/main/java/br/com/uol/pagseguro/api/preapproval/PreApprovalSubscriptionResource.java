package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.Endpoints;
import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.exception.PagSeguroLibException;
import br.com.uol.pagseguro.api.http.HttpClient;
import br.com.uol.pagseguro.api.http.HttpMethod;
import br.com.uol.pagseguro.api.http.HttpResponse;
import br.com.uol.pagseguro.api.utils.Builder;
import br.com.uol.pagseguro.api.utils.CharSet;
import br.com.uol.pagseguro.api.utils.RequestMap;
import br.com.uol.pagseguro.api.utils.logging.Log;
import br.com.uol.pagseguro.api.utils.logging.LoggerFactory;

import java.io.IOException;

/**
 * Factory to pre approval subscription
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSubscriptionResource {

    private static final Log LOGGER = LoggerFactory.getLogger(PreApprovalSubscriptionResource.class.getName());

    private static final PreApprovalSubscriptionV2MapConverter PRE_APPROVAL_SUBSCRIPTION_MC =
            new PreApprovalSubscriptionV2MapConverter();

    private final PagSeguro pagSeguro;
    private final HttpClient httpClient;

    public PreApprovalSubscriptionResource(PagSeguro pagSeguro, HttpClient httpClient) {
        this.pagSeguro = pagSeguro;
        this.httpClient = httpClient;
    }

    /**
     * Pre Approval Subscription
     *
     * @param preApprovalRegistrationBuilder Builder for Pre Approval Subscription
     * @return Response of pre approval registration
     * @see PreApprovalRegistration
     * @see RegisteredPreApproval
     */
    public SubscribedPreApproval subscribe(Builder<PreApprovalSubscription> preApprovalRegistrationBuilder) {
        return subscribe(preApprovalRegistrationBuilder.build());
    }

    /**
     * Pre Approval Subscription
     *
     * @param preApprovalRegistration Pre Approval Subscription
     * @return Response of pre approval subscription
     * @see PreApprovalRegistration
     * @see SubscribedPreApproval
     */
    public SubscribedPreApproval subscribe(PreApprovalSubscription preApprovalRegistration) {
        LOGGER.info("Iniciando adesão pre approval");
        LOGGER.info("Convertendo valores");
        final RequestMap map = PRE_APPROVAL_SUBSCRIPTION_MC.convert(preApprovalRegistration);
        LOGGER.info("Valores convertidos");
        final HttpResponse response;
        try {
            LOGGER.debug(String.format("Parametros: %s", map));
            response = httpClient.execute(HttpMethod.POST, String.format(Endpoints.PRE_APPROVALS,
                    pagSeguro.getHost()), null, map.toHttpRequestBody(CharSet.ENCODING_ISO));
            LOGGER.debug(String.format("Resposta: %s", response.toString()));
        } catch (IOException e) {
            LOGGER.error("Erro ao executar registro pre approval");
            throw new PagSeguroLibException(e);
        }
        LOGGER.info("Parseando XML de resposta");
        SubscribePreApprovalResponseXML subscribedPreApproval = response.parseXMLContent(pagSeguro,
                SubscribePreApprovalResponseXML.class);
        LOGGER.info("Parseamento finalizado");
        LOGGER.info("Assinatura pre approval finalizado");
        return subscribedPreApproval;
    }

    public void cancel() {}

    public void updatePaymentMethod() {}
}

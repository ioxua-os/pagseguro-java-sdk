package br.com.uol.pagseguro.api.boleto;

import br.com.uol.pagseguro.api.PagSeguroSandboxEnv;
import br.com.uol.pagseguro.api.Resource4Test;
import br.com.uol.pagseguro.api.common.domain.builder.DocumentBuilder;
import br.com.uol.pagseguro.api.common.domain.builder.PhoneBuilder;
import br.com.uol.pagseguro.api.common.domain.enums.DocumentType;
import br.com.uol.pagseguro.api.http.HttpJsonRequestBody;
import br.com.uol.pagseguro.api.http.HttpMethod;
import br.com.uol.pagseguro.api.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class BoletoRegistrationTest extends Resource4Test {

    private BoletoResource boletoResource;

    private BoletoRegistration boletoRegistration;
    private DateTimeFormatter dateFormat;

    @Before
    public void setUp() throws Exception {
        boletoResource = new BoletoResource(pagSeguro, httpClient);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = calendar.getTime();
        boletoRegistration = new BoletoRegistrationBuilder()
                .withAmount(BigDecimal.TEN)
                .withDescription("this is a description")
                .withNumberOfPayments(1)
                .withPeriodicity(BoletoRegistrationPeriodicity.MONTHLY)
                .withFirstDueDate(tomorrow)
                .withCustomer(new BoletoCustomerBuilder()
                        .withEmail("prettynormalemail@gmail.com")
                        .withName("Pretty Normal Name")
                        .withPhone(new PhoneBuilder()
                                .withAreaCode("11")
                                .withNumber("959128954")
                        .build())
                        .withDocument(new DocumentBuilder()
                                .withType(DocumentType.CPF)
                                .withValue("26057705084")
                        .build())
                .build())
        .build();

        dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Test
    public void shouldDeserialize() throws Exception {
        String actualCode = "603E53A1-521D-417E-9C8C-0F7DA6010QWE";
        String actualPaymentLink = "https://pagseguro.uol.com.br/checkout/payment/booklet/print.jhtml?c=80739df45g7c3fdd970651b0457b16d6c2fa7a0f6a42d1620098ad042c829c1a8389ca9026947cab";
        String actualBarcode = "03399853012970000066349145501011233430012300610";
        String actualDueDateAsString = "2020-08-10";
        LocalDate actualDueDate = LocalDate.parse(actualDueDateAsString, dateFormat);

        String responseAsString = "{" +
                " \"boletos\": [" +
                "  {" +
                "   \"code\": \"" + actualCode + "\"," +
                "   \"paymentLink\": \"" + actualPaymentLink + "\"," +
                "   \"barcode\": \"" + actualBarcode + "\"," +
                "   \"dueDate\": \"" + actualDueDateAsString + "\"" +
                "  }" +
                " ]" +
                "}";
        HttpResponse response = new HttpResponse(200, responseAsString);
        when(httpClient.executeJson(any(HttpMethod.class), anyString(), anyMap(),
                any(HttpJsonRequestBody.class))).thenReturn(response);

        RegisteredBoletos registeredBoletos = boletoResource.register(boletoRegistration);
        assertNotNull(registeredBoletos);
        assertNotNull(registeredBoletos.getBoletos());

        assertEquals(registeredBoletos.getBoletos().size(), 1);

        RegisteredBoleto boleto = registeredBoletos.getBoletos().get(0);
        assertNotNull(boleto);
        assertEquals(boleto.getCode(), actualCode);
        assertEquals(boleto.getBarcode(), actualBarcode);
        assertEquals(boleto.getPaymentLink(), actualPaymentLink);
        assertEquals(boleto.getDueDate(), actualDueDate);
    }

    @Test
    public void shouldRegister() {
        if (pagSeguro instanceof PagSeguroSandboxEnv) {
            logger.warn("Boletos only work on PRODUCTION env. Ignoring BoletoRegistrationTest#shouldRegister");
            return;
        }

        RegisteredBoletos registeredBoletos = boletoResource.register(boletoRegistration);
        assertNotNull(registeredBoletos);
        assertNotNull(registeredBoletos.getBoletos());

        assertEquals(registeredBoletos.getBoletos().size(),
                boletoRegistration.getNumberOfPayments().intValue());

        RegisteredBoleto boleto = registeredBoletos.getBoletos().get(0);
        assertNotNull(boleto);
        assertNotNull(boleto.getDueDate());
        assertNotNull(boleto.getPaymentLink());
        assertNotNull(boleto.getBarcode());
        assertNotNull(boleto.getCode());
    }
}

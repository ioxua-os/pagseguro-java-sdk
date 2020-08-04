package br.com.uol.pagseguro.api.transaction.register;

import br.com.uol.pagseguro.api.common.domain.Parameter;
import br.com.uol.pagseguro.api.common.domain.PaymentItem;
import br.com.uol.pagseguro.api.common.domain.Sender;
import br.com.uol.pagseguro.api.common.domain.Shipping;
import br.com.uol.pagseguro.api.common.domain.enums.Currency;
import br.com.uol.pagseguro.api.utils.RequestMap;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TransactionRegistrationV2MapConverterTest {

  private TransactionRegistration transactionRegistration;

  private TransactionRegistrationV2MapConverter mapConverter;

  @Before
  public void setUp() {
    mapConverter = new TransactionRegistrationV2MapConverter();

    transactionRegistration = new SimpleTransactionRegistration();
  }

  @Test
  public void shouldConvert() {
    RequestMap expectedMap = new RequestMap();
    expectedMap.putMap(new HashMap<String, String>() {{
      put("extraAmount", "10.00");
      put("paymentMode", "paymentMode");
      put("currency", "BRL");
      put("notificationURL", "notificationURL");
      put("reference", "reference");
    }});

    RequestMap map = mapConverter.convert(transactionRegistration);

    assertEquals(expectedMap, map);
  }

  private static class SimpleTransactionRegistration implements TransactionRegistration {

    @Override
    public String getPaymentMode() {
      return "paymentMode";
    }

    @Override
    public Currency getCurrency() {
      return Currency.BRL;
    }

    @Override
    public List<? extends PaymentItem> getItems() {
      return null;
    }

    @Override
    public String getNotificationURL() {
      return "notificationURL";
    }

    @Override
    public String getReference() {
      return "reference";
    }

    @Override
    public Sender getSender() {
      return null;
    }

    @Override
    public Shipping getShipping() {
      return null;
    }

    @Override
    public List<? extends Parameter> getParameters() {
      return null;
    }

    @Override
    public BigDecimal getExtraAmount() {
      return new BigDecimal(10);
    }
  }
}

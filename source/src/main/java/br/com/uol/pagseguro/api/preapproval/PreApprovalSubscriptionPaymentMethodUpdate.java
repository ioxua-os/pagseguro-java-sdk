package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalCreditCard;
import br.com.uol.pagseguro.api.common.domain.PreApprovalSender;

public interface PreApprovalSubscriptionPaymentMethodUpdate {
    String getType();
    PreApprovalSender getSender();
    PreApprovalCreditCard getCreditCard();
}

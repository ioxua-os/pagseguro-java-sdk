package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethodV2;
import br.com.uol.pagseguro.api.common.domain.Sender;

/**
 * Interface for pre approval subscription
 *
 * @author Yehoshua Oliveira
 */
public interface PreApprovalSubscription {

    /**
     * URL where the buyer is redirected after completion of the signature stream.
     *
     * @return Redirect Url
     */
    String getRedirectURL();

    /**
     * Code / identifier to reference the signature on your system.
     *
     * @return Reference
     */
    String getReference();

    /**
     * Buyer Data
     *
     * @return Sender
     * @see Sender
     */
    Sender getSender();

    /**
     * Get pre approval credit card data
     * @return PreApprovalCreditCardV2
     * @see PreApprovalPaymentMethodV2
     */
    PreApprovalPaymentMethodV2 getPreApprovalPaymentMethod();

}

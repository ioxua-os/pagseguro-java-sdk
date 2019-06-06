package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethod;
import br.com.uol.pagseguro.api.common.domain.Sender;

/**
 * Interface for pre approval subscription
 *
 * @author Yehoshua Oliveira
 */
public interface PreApprovalSubscription {

    /**
     * Code of the pre approval plan, returned by /pre-approvals/request.
     *
     * @return Plan Code
     */
    String getPlan();

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
     * @return PreApprovalCreditCard
     * @see PreApprovalPaymentMethod
     */
    PreApprovalPaymentMethod getPreApprovalPaymentMethod();

}

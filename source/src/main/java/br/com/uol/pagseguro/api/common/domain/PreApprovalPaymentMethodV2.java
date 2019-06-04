package br.com.uol.pagseguro.api.common.domain;

/**
 * Interface for Pre Approval Payment Method. This class contains all the payment data.
 *
 * @author Yehoshua Oliveira.
 */
public interface PreApprovalPaymentMethodV2 {
    /**
     * Get type of payment
     * @return Type
     */
    String getType();

    /**
     * Get pre approval credit card data
     * @return PreApprovalCreditCard
     */
    CreditCard getCreditCard();
}

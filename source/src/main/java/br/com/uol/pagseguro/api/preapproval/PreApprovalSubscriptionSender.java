package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.Address;
import br.com.uol.pagseguro.api.common.domain.Phone;

/**
 * Interface representing a pre approval sender whe searching for subscriptions
 *
 * @author Yehoshua Oliveira
 */
public interface PreApprovalSubscriptionSender {

    /**
     * @return The pre approval sender's name
     */
    String getName();

    /**
     * @return The pre approval sender's email
     */
    String getEmail();

    /**
     * @return The pre approval sender's phone
     */
    Phone getPhone();

    /**
     * @return The pre approval sender's address
     */
    Address getAddress();
}

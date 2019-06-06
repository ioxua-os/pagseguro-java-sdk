package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalStatus;

import java.util.Date;

/**
 * Interface representing a pre approval subscription summary
 *
 * @author Yehoshua Oliveira
 */
public interface PreApprovalSubscriptionSummary {
    /**
     * @return the pre approval name
     */
    String getName();

    /**
     * @return the pre approval subscription code
     */
    String getCode();

    /**
     * @return the pre approval subscription creation date
     */
    Date getDate();

    /**
     * @return the pre approval subscription tracking code
     */
    String getTracker();

    /**
     * @return the pre approval subscription status
     */
    PreApprovalStatus.Status getStatus();

    /**
     * @return the pre approval subscription status id
     */
    String getStatusId();

    /**
     * @return the pre approval subscription reference code
     */
    String getReference();

    /**
     * @return the pre approval subscription last event date
     */
    Date getLastEvent();

    /**
     * @return the pre approval subscription charging mode (AUTO or MANUAL)
     */
    // @TODO: maybe add an enum here
    String getChargeMode();

    /**
     * @return the pre approval subscription sender data
     */
    PreApprovalSubscriptionSender getSender();
}

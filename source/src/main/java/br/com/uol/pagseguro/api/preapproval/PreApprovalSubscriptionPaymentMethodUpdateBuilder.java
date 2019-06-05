package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalCreditCard;
import br.com.uol.pagseguro.api.common.domain.PreApprovalSender;
import br.com.uol.pagseguro.api.utils.Builder;

public class PreApprovalSubscriptionPaymentMethodUpdateBuilder implements Builder<PreApprovalSubscriptionPaymentMethodUpdate> {
    private String type;
    private PreApprovalSender sender;
    private PreApprovalCreditCard creditCard;

    /**
     * Set the pre approval subscription update payment type
     *
     * @param type The type for the new payment method
     * @return Builder for pre approval subscription update
     * @see PreApprovalSubscriptionPaymentMethodUpdate#getType()
     */
    public PreApprovalSubscriptionPaymentMethodUpdateBuilder withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Set the pre approval subscription update sender
     *
     * @param sender The sender for the new payment method
     * @return Builder for pre approval subscription update
     * @see PreApprovalSubscriptionPaymentMethodUpdate#getType()
     */
    public PreApprovalSubscriptionPaymentMethodUpdateBuilder withSender(PreApprovalSender sender) {
        this.sender = sender;
        return this;
    }

    /**
     * Set the pre approval subscription update sender
     *
     * @param sender The sender for the new payment method
     * @return Builder for pre approval subscription update
     * @see PreApprovalSubscriptionPaymentMethodUpdate#getType()
     */
    public PreApprovalSubscriptionPaymentMethodUpdateBuilder withSender(Builder<PreApprovalSender> sender) {
        return withSender(sender.build());
    }

    /**
     * Set the pre approval subscription update creditCard
     *
     * @param creditCard The creditCard for the new payment method
     * @return Builder for pre approval subscription update
     * @see PreApprovalSubscriptionPaymentMethodUpdate#getType()
     */
    public PreApprovalSubscriptionPaymentMethodUpdateBuilder withCreditCard(PreApprovalCreditCard creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    /**
     * Set the pre approval subscription update creditCard
     *
     * @param creditCard The creditCard for the new payment method
     * @return Builder for pre approval subscription update
     * @see PreApprovalSubscriptionPaymentMethodUpdate#getType()
     */
    public PreApprovalSubscriptionPaymentMethodUpdateBuilder withCreditCard(Builder<PreApprovalCreditCard> creditCard) {
        return withCreditCard(creditCard.build());
    }

    @Override
    public PreApprovalSubscriptionPaymentMethodUpdate build() {
        return new SimplePreApprovalSubscriptionPaymentMethodChange(this);
    }

    private class SimplePreApprovalSubscriptionPaymentMethodChange implements PreApprovalSubscriptionPaymentMethodUpdate {
        private PreApprovalSubscriptionPaymentMethodUpdateBuilder builder;

        SimplePreApprovalSubscriptionPaymentMethodChange(PreApprovalSubscriptionPaymentMethodUpdateBuilder builder) {
            this.builder = builder;
        }

        @Override
        public String getType() {
            return builder.type;
        }

        @Override
        public PreApprovalSender getSender() {
            return builder.sender;
        }

        @Override
        public PreApprovalCreditCard getCreditCard() {
            return builder.creditCard;
        }
    }
}

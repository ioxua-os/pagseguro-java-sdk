package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethod;
import br.com.uol.pagseguro.api.common.domain.Sender;
import br.com.uol.pagseguro.api.utils.Builder;

public class PreApprovalSubscriptionBuilder implements Builder<PreApprovalSubscription> {
    private String redirectURL;
    private String reference;
    private Sender sender;
    private PreApprovalPaymentMethod preApprovalPaymentMethod;

    /**
     * Set redirect url of pre approval subscription
     *
     * @param redirectURL Redirect Url
     * @return Builder for pre approval subscription
     * @see PreApprovalSubscription#getRedirectURL()
     */
    public PreApprovalSubscriptionBuilder withRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
        return this;
    }

    /**
     * Set Reference of pre approval subscription
     *
     * @param reference Reference
     * @return Builder for pre approval subscription
     * @see PreApprovalSubscription#getReference()
     */
    public PreApprovalSubscriptionBuilder withReference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Set Sender of pre approval subscription
     *
     * @param sender Sender
     * @return Builder for pre approval registration
     * @see PreApprovalSubscription#getSender()
     */
    public PreApprovalSubscriptionBuilder withSender(Sender sender) {
        this.sender = sender;
        return this;
    }

    /**
     * Set Sender of pre approval subscription
     *
     * @param senderBuilder Builder for Sender
     * @return Builder for pre approval registration
     * @see PreApprovalSubscription#getSender()
     */
    public PreApprovalSubscriptionBuilder withSender(Builder<Sender> senderBuilder) {
        return withSender(senderBuilder.build());
    }

    /**
     * Set Payment Method of pre approval subscription
     *
     * @param preApprovalPaymentMethodBuilder Builder for Payment Method
     * @return Builder for pre approval registration
     * @see PreApprovalSubscription#getSender()
     */
    public PreApprovalSubscriptionBuilder withPaymentMethod(Builder<PreApprovalPaymentMethod> preApprovalPaymentMethodBuilder) {
        return withPaymentMethod(preApprovalPaymentMethodBuilder.build());
    }

    /**
     * Set Payment Method of pre approval subscription
     *
     * @param preApprovalPaymentMethod Payment Method
     * @return Builder for pre approval registration
     * @see PreApprovalSubscription#getSender()
     */
    public PreApprovalSubscriptionBuilder withPaymentMethod(PreApprovalPaymentMethod preApprovalPaymentMethod) {
        this.preApprovalPaymentMethod = preApprovalPaymentMethod;
        return this;
    }

    @Override
    public PreApprovalSubscription build() {
        return new SimplePreApprovalSubscription(this);
    }

    private static class SimplePreApprovalSubscription implements PreApprovalSubscription {
        private final PreApprovalSubscriptionBuilder preApprovalSubscriptionBuilder;

        public SimplePreApprovalSubscription(PreApprovalSubscriptionBuilder preApprovalSubscriptionBuilder) {
            this.preApprovalSubscriptionBuilder = preApprovalSubscriptionBuilder;
        }

        @Override
        public String getRedirectURL() {
            return this.preApprovalSubscriptionBuilder.redirectURL;
        }

        @Override
        public String getReference() {
            return this.preApprovalSubscriptionBuilder.reference;
        }

        @Override
        public Sender getSender() {
            return this.preApprovalSubscriptionBuilder.sender;
        }

        @Override
        public PreApprovalPaymentMethod getPreApprovalPaymentMethod() {
            return this.preApprovalSubscriptionBuilder.preApprovalPaymentMethod;
        }
    }
}

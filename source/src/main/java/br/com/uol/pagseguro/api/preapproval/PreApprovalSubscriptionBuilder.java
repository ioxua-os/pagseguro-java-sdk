package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.common.domain.PreApprovalPaymentMethodV2;
import br.com.uol.pagseguro.api.common.domain.Sender;
import br.com.uol.pagseguro.api.utils.Builder;

public class PreApprovalSubscriptionBuilder implements Builder<PreApprovalSubscription> {
    private String redirectURL;
    private String reference;
    private Sender sender;
    private PreApprovalPaymentMethodV2 preApprovalPaymentMethod;

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
    public PreApprovalSubscriptionBuilder withPaymentMethod(Builder<PreApprovalPaymentMethodV2> preApprovalPaymentMethodBuilder) {
        return withPaymentMethod(preApprovalPaymentMethodBuilder.build());
    }

    /**
     * Set Payment Method of pre approval subscription
     *
     * @param preApprovalPaymentMethod Payment Method
     * @return Builder for pre approval registration
     * @see PreApprovalSubscription#getSender()
     */
    public PreApprovalSubscriptionBuilder withPaymentMethod(PreApprovalPaymentMethodV2 preApprovalPaymentMethod) {
        this.preApprovalPaymentMethod = preApprovalPaymentMethod;
        return this;
    }

    @Override
    public PreApprovalSubscription build() {
        return new SimplePreApprovalSubscriptionBuilder(this);
    }

    private static class SimplePreApprovalSubscriptionBuilder implements PreApprovalSubscription {
        private final PreApprovalSubscriptionBuilder preApprovalSubscriptionBuilder;

        public SimplePreApprovalSubscriptionBuilder(PreApprovalSubscriptionBuilder preApprovalSubscriptionBuilder) {
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
        public PreApprovalPaymentMethodV2 getPreApprovalPaymentMethod() {
            return this.preApprovalSubscriptionBuilder.preApprovalPaymentMethod;
        }
    }
}

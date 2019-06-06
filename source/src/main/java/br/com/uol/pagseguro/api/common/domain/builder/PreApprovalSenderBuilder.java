package br.com.uol.pagseguro.api.common.domain.builder;

import br.com.uol.pagseguro.api.common.domain.PreApprovalSender;
import br.com.uol.pagseguro.api.utils.Builder;

/**
 * Builder for Pre Approval Sender
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSenderBuilder implements Builder<PreApprovalSender> {
    private String hash;

    /**
     * Set hash of sender
     *
     * @param hash String
     * @return Builder for pre approval sender
     * @see PreApprovalSender#getHash()
     */
    public PreApprovalSenderBuilder withHash(String hash) {
        this.hash = hash;
        return this;
    }

    @Override
    public PreApprovalSender build() {
        return new SimplePreApprovalSender(this);
    }

    private class SimplePreApprovalSender implements PreApprovalSender {
        private PreApprovalSenderBuilder builder;

        SimplePreApprovalSender(PreApprovalSenderBuilder builder) {
            this.builder = builder;
        }

        @Override
        public String getHash() {
            return this.builder.hash;
        }
    }
}

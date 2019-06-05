package br.com.uol.pagseguro.api.common.domain.converter;

import br.com.uol.pagseguro.api.common.domain.PreApprovalSender;
import br.com.uol.pagseguro.api.utils.AbstractJsonConverter;
import br.com.uol.pagseguro.api.utils.RequestJson;
/**
 * Converter for Pre Approval Sender
 *
 * @author Yehoshua Oliveira
 */
public class PreApprovalSenderJsonConverter extends AbstractJsonConverter<PreApprovalSender> {
    @Override
    protected void convert(RequestJson requestJson, PreApprovalSender preApprovalSender) {
        requestJson.putString("hash", preApprovalSender.getHash());
    }
}

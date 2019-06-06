package br.com.uol.pagseguro.api.preapproval;

import br.com.uol.pagseguro.api.PagSeguro;
import br.com.uol.pagseguro.api.common.domain.PreApprovalStatus;
import br.com.uol.pagseguro.api.utils.XMLUnmarshallListener;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Implementation of {@code PreApprovalSubscriptionSummary} and {@code XMLUnmarshallListener}
 *
 * @author Yehoshua Oliveira
 */
@XmlRootElement(name = "preApproval")
public class PreApprovalSubscriptionSummaryResponseXML implements PreApprovalSubscriptionSummary, XMLUnmarshallListener {

    private PagSeguro pagSeguro;

    private String name;
    private String code;
    private Date date;
    private String tracker;
    private String statusId;
    private String reference;
    private Date lastEvent;
    private String chargeMode;
    private PreApprovalSubscriptionSenderXML sender;

    @Override
    public String getName() {
        return this.name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getTracker() {
        return this.tracker;
    }

    @XmlElement
    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    @Override
    public PreApprovalStatus.Status getStatus() {
        return PreApprovalStatus.Status.fromStatusId(statusId);
    }

    @Override
    public String getStatusId() {
        return this.statusId;
    }

    @XmlElement(name = "status")
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public String getReference() {
        return this.reference;
    }

    @XmlElement
    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public Date getLastEvent() {
        return this.lastEvent;
    }

    @XmlElement
    public void setLastEvent(Date lastEvent) {
        this.lastEvent = lastEvent;
    }

    @Override
    public String getChargeMode() {
        return this.chargeMode;
    }

    @XmlElement(name = "charge")
    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode;
    }

    @Override
    public PreApprovalSubscriptionSender getSender() {
        return this.sender;
    }

    @XmlElement
    public void setSender(PreApprovalSubscriptionSenderXML sender) {
        this.sender = sender;
    }

    @Override
    public void onUnmarshal(PagSeguro pagseguroAPI, String rawData) {
        this.pagSeguro = pagseguroAPI;
    }
}

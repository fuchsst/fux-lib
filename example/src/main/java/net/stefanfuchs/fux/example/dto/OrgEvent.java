package net.stefanfuchs.fux.example.dto;

import java.util.Date;

/**
 * @author fuchsste
 */
public class OrgEvent {
    private long orgId;
    private long loginId;
    private Date eventTime;
    private int sourceId;
    private int eventType;
    private int verticalId;

    public OrgEvent() {
    }

    public OrgEvent(long orgId, long loginId, Date eventTime, int sourceId, int eventType, int verticalId) {
        this.orgId = orgId;
        this.loginId = loginId;
        this.eventTime = eventTime;
        this.sourceId = sourceId;
        this.eventType = eventType;
        this.verticalId = verticalId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public long getLoginId() {
        return loginId;
    }

    public void setLoginId(long loginId) {
        this.loginId = loginId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(int verticalId) {
        this.verticalId = verticalId;
    }

    @Override
    public String toString() {
        return "OrgEvent{" +
                "orgId=" + orgId +
                ", loginId=" + loginId +
                ", eventTime=" + eventTime +
                ", sourceId=" + sourceId +
                ", eventType=" + eventType +
                ", verticalId=" + verticalId +
                '}';
    }
}

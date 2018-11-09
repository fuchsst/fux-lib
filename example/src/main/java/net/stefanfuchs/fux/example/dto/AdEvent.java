package net.stefanfuchs.fux.example.dto;

import java.util.Date;

/**
 * @author fuchsste
 */
public class AdEvent {

    private long adId;
    private long loginId;
    private Date eventTime;
    private int sourceId;
    private int eventType;
    private int verticalId;

    public AdEvent() {
    }

    public AdEvent(long adId, long loginId, Date eventTime, int sourceId, int eventType, int verticalId) {
        this.adId = adId;
        this.loginId = loginId;
        this.eventTime = eventTime;
        this.sourceId = sourceId;
        this.eventType = eventType;
        this.verticalId = verticalId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
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

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(int verticalId) {
        this.verticalId = verticalId;
    }

    @Override
    public String toString() {
        return "AdEvent{" +
                "adId=" + adId +
                ", loginId=" + loginId +
                ", eventTime=" + eventTime +
                ", sourceId=" + sourceId +
                ", eventType=" + eventType +
                ", verticalId=" + verticalId +
                '}';
    }
}

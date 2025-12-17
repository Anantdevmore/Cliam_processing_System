package com.audit.DTO;

import lombok.Data;

@Data
public class AuditLogRequestDto {
    private Long userId;
    private String serviceName; // CLAIM, PAYMENT, NOTIFICATION, USER
    private String action;      // created, updated, deleted, etc.
    private String message;

    public AuditLogRequestDto() {
    }

    public AuditLogRequestDto(Long userId, String serviceName, String action, String message) {
        this.userId = userId;
        this.serviceName = serviceName;
        this.action = action;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AuditLogRequestDto{" +
                "userId=" + userId +
                ", serviceName='" + serviceName + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

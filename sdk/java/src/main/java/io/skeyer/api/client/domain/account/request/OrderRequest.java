package io.skeyer.api.client.domain.account.request;

import io.skeyer.api.client.constant.SkeyerConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base request parameters for order-related methods.
 */
public class OrderRequest {

    private Long recvWindow;

    private Long timestamp;

    public OrderRequest() {
        this.timestamp = System.currentTimeMillis();
        this.recvWindow = SkeyerConstants.DEFAULT_RECEIVING_WINDOW;
    }

    public Long getRecvWindow() {
        return recvWindow;
    }

    public OrderRequest recvWindow(Long recvWindow) {
        this.recvWindow = recvWindow;
        return this;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public OrderRequest timestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SkeyerConstants.TO_STRING_BUILDER_STYLE)
                .append("recvWindow", recvWindow)
                .append("timestamp", timestamp)
                .toString();
    }
}

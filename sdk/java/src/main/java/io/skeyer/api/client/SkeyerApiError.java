package io.skeyer.api.client;

import io.skeyer.api.client.constant.SkeyerConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Skeyer API error object.
 */
public class SkeyerApiError {

    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, SkeyerConstants.TO_STRING_BUILDER_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}

package com.project.model.transer;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by user on 4/6/2017.
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    private Boolean success;
    private String errorCode;
    private String errorMessage;

    public BaseResponse() {
        success = true;
        errorCode = null;
        errorMessage = null;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

package com.ref.base.exception;

import com.ref.base.constant.CommonConstant.ErrorCode;

public class BusinessException extends RuntimeException {
    static final long serialVersionUID = -7036897290745746979L;

    private ErrorCode errorCode;

    private String detailMsg;

    public BusinessException() {

    }

    public BusinessException(ErrorCode errorCode, String detailMsg) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.detailMsg = detailMsg;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, Throwable e) {
        super(errorCode.getDescription(), e);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }
}

package com.ref.base.util;


import com.ref.base.constant.CommonConstant.ErrorCode;
import com.ref.base.exception.BusinessException;

public class ParamUtil {
    public static <T> T checkNotNull(T reference, ErrorCode... errorCodes) {
        if (reference == null) {
            throw new BusinessException(errorCodes.length > 0 ? errorCodes[0] : ErrorCode.ERROR_CODE_PARAMETER_ILLEGAL);
        }
        return reference;
    }
	
}

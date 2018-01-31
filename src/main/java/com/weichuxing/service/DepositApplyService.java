package com.weichuxing.service;

import com.weichuxing.utils.WcxResult;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface DepositApplyService {

    /**
     *  申请押金退回
     * @return
     */
    WcxResult applyDepositReturn(String userId,HttpServletRequest request) throws Exception;
}

package com.weichuxing.service;

import com.weichuxing.entity.LockRequest.CloseLockCallbackRequest;
import com.weichuxing.entity.LockRequest.OpenLockCallbackRequest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface LockCallbackService {

    void openLockCallback(OpenLockCallbackRequest lockCallbackRequest) throws InvalidKeySpecException, NoSuchAlgorithmException;

    void closeLockCallback(CloseLockCallbackRequest closeLockCallbackRequest) throws InvalidKeySpecException, NoSuchAlgorithmException;
}

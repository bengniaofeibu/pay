package com.weichuxing.controller.AmountController;

import com.weichuxing.controller.BaseController;
import com.weichuxing.entity.WcxRequest.DepositApplyRequest;
import com.weichuxing.model.TransRecordAmount;
import com.weichuxing.service.AmountInfoService;
import com.weichuxing.service.DepositApplyService;
import com.weichuxing.utils.ResultUtil;
import com.weichuxing.utils.WcxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AmountInfoController extends BaseController{

      @Resource(name = "amountInfoService")
      private AmountInfoService amountInfoService;

      @Autowired
      private DepositApplyService depositApplyService;



      @GetMapping(value = "/vcx_notify_pay_result.fcgi")
      public WcxResult addAmountInfo(TransRecordAmount transRecordAmount){
          //解码和验证签名
          TransRecordAmount recordAmount = verificationSignAndDecode(transRecordAmount, TransRecordAmount.class);
          amountInfoService.addAmountRecord(recordAmount);
          return ResultUtil.success();
      }


      @PostMapping(value = "/vcx_mch_ret_deposit_apply")
      public WcxResult retDepositApply(DepositApplyRequest depositApplyRequest, HttpServletRequest request) throws Exception {
          //解码和验证签名
//          DepositApplyRequest depositApply = verificationSignAndDecode(depositApplyRequest, DepositApplyRequest.class);
          depositApplyService.applyDepositReturn(depositApplyRequest.getUserid(),request);
          return ResultUtil.success();
      }
}

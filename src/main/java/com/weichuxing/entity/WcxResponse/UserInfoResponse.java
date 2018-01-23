package com.weichuxing.entity.WcxResponse;



public class UserInfoResponse extends  BaseWcxReponse{


    /**
     *   微出行发起的向各个单车平台查询用户是否注册 ，是否缴纳押金的接口，并把结果展示给用户
     */


    /**
     * 注册标识
     * 1：未注册
     * 2 ：已在微出行平台注册
     * 3 ：已在车商侧注册
     **/
   private Integer regist_flag=1;

   /**
    * 押金标识
    * 1：表示该用户未交押金
    * 2 ：表示该用户在微出行平台已交押金
    * 3 ：表示该用户在车商已交押金
    * 4 ：表示该用户免押金状态中(微出行限时免押)
    * 5 ：表示该用户在车商已退押金
    **/
   private Integer deposit_flag=1;

   /** 押金费用 （单位分） **/
   private Long deposit_fee=0L;

   /** 车费卡数目 **/
   private Integer farecard_num;

   /** 车费卡列表  **/
   private FarecardInfoResponse[]  farecard_list;

    public Integer getRegist_flag() {
        return regist_flag;
    }

    public void setRegist_flag(Integer regist_flag) {
        this.regist_flag = regist_flag;
    }

    public Integer getDeposit_flag() {
        return deposit_flag;
    }

    public void setDeposit_flag(Integer deposit_flag) {
        this.deposit_flag = deposit_flag;
    }

    public Long getDeposit_fee() {
        return deposit_fee;
    }

    public void setDeposit_fee(Long deposit_fee) {
        this.deposit_fee = deposit_fee;
    }

    public Integer getFarecard_num() {
        return farecard_num;
    }

    public void setFarecard_num(Integer farecard_num) {
        this.farecard_num = farecard_num;
    }

    public FarecardInfoResponse[] getFarecard_list() {
        return farecard_list;
    }

    public void setFarecard_list(FarecardInfoResponse[] farecard_list) {
        this.farecard_list = farecard_list;
    }
}

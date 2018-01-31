package com.weichuxing.entity.WcxResponse;

public class ScavengingUnlockResponse extends BaseWcxResponse{

    /*单车ID*/
    private String bike_id;

    /*车型编号*/
    private String model_id;

    /*
    * 车锁类型
    * 1: 蓝牙锁
    * 2: 智能锁(GSM, GPRS, NB-IOT)
    * 3: 智能锁 + 蓝牙锁
    * 4: 机械锁
    * 5: 智能锁 + 机械锁
    * 6: 蓝牙锁 + 机械锁
    * */
    private Integer model_type;

    /*选填
    * 车锁状态，机械锁时才返回此状态
    * 1: locked
    * 2: unlocked
    * */
    private Integer bike_status;

    /*选填
    *机械锁密码，机械锁开锁使用 */
    private String bike_passwd;

    /*选填
    *蓝牙锁设备ID，创建蓝牙连接使用*/
    private String blelock_deviceid;

    /*选填
    * 蓝牙锁token认证串 */
    private String blelock_token;

    /*选填
    * 鉴权码 */
    private String auth_code;

    /*选填
    * 蓝牙锁服务器鉴权token */
    private String auth_token;

    /*选填
    * 蓝牙锁服务器地址*/
    private String blelock_url;

    public String getBike_id() {
        return bike_id;
    }

    public void setBike_id(String bike_id) {
        this.bike_id = bike_id;
    }

    public String getModel_id() {
        return model_id;
    }

    public void setModel_id(String model_id) {
        this.model_id = model_id;
    }

    public Integer getModel_type() {
        return model_type;
    }

    public void setModel_type(Integer model_type) {
        this.model_type = model_type;
    }

    public Integer getBike_status() {
        return bike_status;
    }

    public void setBike_status(Integer bike_status) {
        this.bike_status = bike_status;
    }

    public String getBike_passwd() {
        return bike_passwd;
    }

    public void setBike_passwd(String bike_passwd) {
        this.bike_passwd = bike_passwd;
    }

    public String getBlelock_deviceid() {
        return blelock_deviceid;
    }

    public void setBlelock_deviceid(String blelock_deviceid) {
        this.blelock_deviceid = blelock_deviceid;
    }

    public String getBlelock_token() {
        return blelock_token;
    }

    public void setBlelock_token(String blelock_token) {
        this.blelock_token = blelock_token;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public String getBlelock_url() {
        return blelock_url;
    }

    public void setBlelock_url(String blelock_url) {
        this.blelock_url = blelock_url;
    }
}

package com.applet.config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.github.wxpay.sdk.WXPayConfig;

@ConfigurationProperties(prefix = "wxPay")
@Component
public class WXPayConfigImpl implements WXPayConfig {

	private byte[] certData;
	private static WXPayConfigImpl INSTANCE;
	
	private String cer;



	private WXPayConfigImpl() throws Exception {
		System.out.println(cer);
//		String certPath = "/home/cer/apiclient_cert.p12";
		String certPath = "D:\\IdeaProjects\\pay\\src\\main\\webapp\\cer\\apiclient_cert.p12";
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}

	public static WXPayConfigImpl getInstance() throws Exception {
		if (INSTANCE == null) {
			synchronized (WXPayConfigImpl.class) {
				if (INSTANCE == null) {
					INSTANCE = new WXPayConfigImpl();
				}
			}
		}
		return INSTANCE;
	}

	public InputStream getCertStream() {
		ByteArrayInputStream certBis;
		certBis = new ByteArrayInputStream(this.certData);
		return certBis;
	}

	/**
	 * 获取 App ID
	 *
	 * @return App ID
	 */

	private String appID = "wx5a008c78857c70ec";

	/**
	 * 获取 Mch ID
	 *
	 * @return Mch ID
	 */
	private String mchID = "1461111202";

	/**
	 * 获取 API 密钥
	 *
	 * @return API密钥
	 */
	private String key = "43DBE8BC489BDC916DE00807BCB4B7D0";

	/**
	 * 获取商户证书内容
	 *
	 * @return 商户证书内容
	 */
	// private InputStream certStream;

	/**
	 * HTTP(S) 连接超时时间，单位毫秒
	 *
	 * @return
	 */
	public int getHttpConnectTimeoutMs() {
		return 6 * 1000;
	}

	/**
	 * HTTP(S) 读数据超时时间，单位毫秒
	 *
	 * @return
	 */
	public int getHttpReadTimeoutMs() {
		return 8 * 1000;
	}

	/**
	 * 获取WXPayDomain, 用于多域名容灾自动切换
	 * 
	 * @return
	 */
	// abstract IWXPayDomain getWXPayDomain();

	/**
	 * 是否自动上报。 若要关闭自动上报，子类中实现该函数返回 false 即可。
	 *
	 * @return
	 */
	public boolean shouldAutoReport() {
		return true;
	}

	/**
	 * 进行健康上报的线程的数量
	 *
	 * @return
	 */
	public int getReportWorkerNum() {
		return 6;
	}

	/**
	 * 健康上报缓存消息的最大数量。会有线程去独立上报 粗略计算：加入一条消息200B，10000消息占用空间 2000 KB，约为2MB，可以接受
	 *
	 * @return
	 */
	public int getReportQueueMaxSize() {
		return 10000;
	}

	/**
	 * 批量上报，一次最多上报多个数据
	 *
	 * @return
	 */
	public int getReportBatchSize() {
		return 10;
	}

	public String getAppID() {
		return "wx5a008c78857c70ec";
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getMchID() {
		return "1461111202";
	}

	public void setMchID(String mchID) {
		this.mchID = mchID;
	}

	public String getKey() {
		return "43DBE8BC489BDC916DE00807BCB4B7D0";
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCer() {
		return cer;
	}

	public void setCer(String cer) {
		this.cer = cer;
	}
	
	

}

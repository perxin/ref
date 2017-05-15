package com.ref.base.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URI;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhengpengxin
 */
public class HttpRestUtils {

	private final static int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 160 * 1000;
	private final static int DEFAULT_CONNECT_TIMEOUT = 160 * 1000;
	private final static int DEFAULT_SOCKET_TIMEOUT = 160 * 1000;
	
	/**
	 * get方式获取url内容
	 * @param url 网址
	 * @param headers httpHead
	 * @param requestCharset 内容请求编码
	 * @param responseCharset 内容解析编码
	 * @param params 请求参数
	 * @return
	 * @throws Exception
	 */
	public static HttpResult fetchGetURLContent(String url, Map<String, String> headers, String requestCharset, String responseCharset, Boolean withSSL, CookieStore cookieStore, NameValuePair... params) throws Exception {
		HttpGet httpGet = new HttpGet(url);
		if(params != null && params.length > 0) {
			StringBuilder paramString = new StringBuilder();
			for(NameValuePair nv : params) {
				if(nv.getValue() != null)
					paramString.append("&").append(nv.getName()).append("=").append(URLEncoder.encode(nv.getValue(), requestCharset));
			}
			if(!url.contains("?")) {
				paramString.replace(0, 1, "?");
			}
			paramString.insert(0, url);
			httpGet.setURI(new URI(paramString.toString()));
		}
		return fetchURLContent(httpGet, headers, responseCharset, withSSL, cookieStore);
	}
	
	/**
	 * post方式获取url内容
	 * @param url 网址
	 * @param headers httpHead
	 * @param requestCharset 内容请求编码
	 * @param responseCharset 内容解析编码
	 * @param params 请求参数
	 * @return
	 * @throws Exception
	 */
	public static HttpResult fetchPostURLContent(String url, Map<String, String> headers, String requestCharset, String responseCharset, Boolean withSSL, CookieStore cookieStore, NameValuePair... params) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		if(params != null && params.length > 0) {
			List<NameValuePair> paramList = new ArrayList<NameValuePair>();
			CollectionUtils.addAll(paramList, params);
			httpPost.setEntity(new UrlEncodedFormEntity(paramList, requestCharset));
		}
		return fetchURLContent(httpPost, headers, responseCharset, withSSL, cookieStore);
	}
	
	
	
	/**
	 * post方式获取url内容
	 * @param url 网址
	 * @param headers httpHead
	 * @param responseCharset 内容解析编码
	 * @param json 请求参数
	 * @return
	 * @throws Exception
	 */
	public static HttpResult fetchPostURLContent(String url, Map<String, String> headers, String responseCharset, Boolean withSSL, CookieStore cookieStore, String json) throws Exception {
		HttpPost httpPost = new HttpPost(url);
		if(json != null) {
			httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
		}
		return fetchURLContent(httpPost, headers, responseCharset, withSSL, cookieStore);
	}
	
	private static HttpResult fetchURLContent(HttpRequestBase httpRequestBase, Map<String, String> headers, String responseCharset, Boolean withSSL, CookieStore cookieStore) throws Exception {
		HttpClientBuilder builder = HttpClients.custom();
		Builder request_builder = RequestConfig.custom()
				.setConnectionRequestTimeout(DEFAULT_CONNECTION_REQUEST_TIMEOUT)
				.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
				.setSocketTimeout(DEFAULT_SOCKET_TIMEOUT);
		if(cookieStore!=null){
			builder.setDefaultCookieStore(cookieStore);
		}
		RequestConfig request_config =request_builder.build();
		builder.setDefaultRequestConfig(request_config);
		
		CloseableHttpClient httpClient = null; 
		if(!withSSL){
			httpClient = builder.build();
		}else {
			httpClient = createHttpsClient();
		}
		if(headers != null && headers.size() > 0) {
			for(String key : headers.keySet()) {
				httpRequestBase.setHeader(new BasicHeader(key, headers.get(key)));
			}
		}
		
		CloseableHttpResponse response = httpClient.execute(httpRequestBase);
		int statusCode = response.getStatusLine().getStatusCode();
		String reasonPhrase = response.getStatusLine().getReasonPhrase();
		String resultString = EntityUtils.toString(response.getEntity(), responseCharset);
		httpRequestBase.releaseConnection();
		return new HttpResult(statusCode, reasonPhrase, resultString);
	}
	
	private static CloseableHttpClient createHttpsClient() {

		X509TrustManager x509mgr = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string) {
			}
			public void checkServerTrusted(X509Certificate[] xcs, String string) {
			}
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		SSLContext sslContext = null;
		try {
			sslContext = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		try {
			sslContext.init(null, new TrustManager[] { x509mgr }, null);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
		//SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
	
	public static class HttpResult {
		private int statusCode;
		private String reasonPhrase;
		private String resultString;
		
		public HttpResult(int statusCode, String reasonPhrase, String resultString) {
			super();
			this.statusCode = statusCode;
			this.reasonPhrase = reasonPhrase;
			this.resultString = resultString;
		}
		public int getStatusCode() {
			return statusCode;
		}
		public String getReasonPhrase() {
			return reasonPhrase;
		}
		public String getResultString() {
			return resultString;
		}
		@Override
		public String toString() {
			return "HttpResult [statusCode=" + statusCode + ", reasonPhrase=" + reasonPhrase + ", resultString=" + resultString + "]";
		}
	}

}

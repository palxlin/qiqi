package com.csi.util;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.util.Properties;

/**
 * Created by Lin on 2017/11/5.
 */
public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final String CONFIG_FILE_NAME = "httputil.properties";
    private static final HttpConnectionManager httpConnectionManager;
    private static final HttpClient httpClient;

    static {

        InputStream is = HttpUtil.class.getResourceAsStream("/" + CONFIG_FILE_NAME);

        Properties p = new Properties();
        try {
            p.load(is);
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        encoding = p.getProperty("http.content.encoding");

        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setConnectionTimeout(Integer.parseInt(p.getProperty("http.connection.timeout")));
        params.setSoTimeout(Integer.parseInt(p.getProperty("http.so.timeout")));
        params.setStaleCheckingEnabled(Boolean.parseBoolean(p.getProperty("http.stale.check.enabled")));
        params.setTcpNoDelay(Boolean.parseBoolean(p.getProperty("http.tcp.no.delay")));
        params.setDefaultMaxConnectionsPerHost(Integer.parseInt(p.getProperty("http.default.max.connections.per.host")));
        params.setMaxTotalConnections(Integer.parseInt(p.getProperty("http.max.total.connections")));
        params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));

        httpConnectionManager = new MultiThreadedHttpConnectionManager();
        httpConnectionManager.setParams(params);

        httpClient = new HttpClient(httpConnectionManager);
    }

    private static String encoding;

    public static byte[] get(String url) {

        GetMethod method = new GetMethod(url);

        method.addRequestHeader("Connection", "Keep-Alive");
        method.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);

        try {
            int statusCode = httpClient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                logger.warn("Abnormal HTTP Status: {}", method.getStatusLine());
                return null;
            }

            return method.getResponseBody();
        } catch (Exception e) {
            logger.warn("http get exception", e);
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public static String get(String url, String encoding) throws Exception {
        try {
            return new String(get(url), encoding);
        } catch (UnsupportedEncodingException e) {

        }
        return null;
    }

    public static String post(String url, String content) throws Exception {
        return post(url, HttpUtil.encoding, content);
    }

    public static String post(String url, String encoding, String content) throws Exception {
        try {
            return new String(post(url, content.getBytes(encoding)), encoding);
        } catch (UnsupportedEncodingException e) {

        }
        return null;
    }

    public static byte[] post(String url, byte[] content) throws Exception {

        logger.info("Request message:[" + new String(content) + "] to " + url);

        byte[] ret = post(url, new ByteArrayRequestEntity(content));
        if (ret != null) {
            logger.info("Response message:[" + new String(ret) + "] from " + url);
        }

        return ret;
    }

    public static byte[] post(String url, RequestEntity requestEntity) throws Exception {

        PostMethod method = new PostMethod(url);
        method.setRequestEntity(requestEntity);
        try {
            int statusCode = httpClient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                logger.warn("Abnormal Http Status: " + method.getStatusLine());
                return null;
            }

            return method.getResponseBody();
        } catch (SocketTimeoutException e) {
            logger.warn("Timeout exception happend while sending to url [" + url + "], Error message:\n" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.warn("Connect exception happend while sending to url [" + url + "], Error message:\n" + e.getMessage(), e);
            logger.warn("[" + url + "]" + e.getMessage() + " <- " + e.getClass().getName());
            throw e;
        } finally {
            method.releaseConnection();
        }
    }
}

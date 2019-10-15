package com.none.authcenter.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.none.authcenter.exception.HttpErrorCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * http请求工具类
 * @author shibaohua
 *
 */
public class HttpClientUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	/**
	 * 
	 * @param url 请求的url
	 * @param obj 参数封装的对象
	 * @return json对象
	 * @throws HttpErrorCodeException
	 */
    public static String post(String url, Object obj) throws HttpErrorCodeException {
		if(logger.isDebugEnabled()){
			logger.debug("post url is "+url+",post parameter is "+obj);
		}
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(obj, MediaType.APPLICATION_JSON));

        try {
        	String res=response.readEntity(String.class);
            if (response.getStatus() != 200 && response.getStatus() != 204) {
                throw new HttpErrorCodeException("Failed with HTTP error code : " + response.getStatus()+",error message:"+res);
            }
    		if(logger.isDebugEnabled()){
    			logger.debug("Successfully got result: " +res );
    		}
           return res;
        }finally {
            response.close();
            client.close();
        }
    }
    
    /**
	 * 
	 * @param url 请求的url
	 * @return  参数封装的json对象
	 * @throws HttpErrorCodeException
	 */
    public static String get(String url) throws HttpErrorCodeException {
		if(logger.isDebugEnabled()){
			logger.debug("Get url is " + url);
		}
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
        	String res=response.readEntity(String.class);
            if (response.getStatus() != 200 && response.getStatus() != 204) {
                throw new HttpErrorCodeException("Failed with HTTP error code : " + response.getStatus()+",error message:"+res);
            }
    		if(logger.isDebugEnabled()){
    			logger.debug("Successfully got result: " +res );
    		}
            return res;
        } finally {
            response.close();
            client.close();
        }
    }
	/**
	 * 
	 * @param url 请求的url
	 * @param obj 参数封装的对象
	 * @return json对象
	 * @throws HttpErrorCodeException
	 */
    public static <T>T post(String url, Object obj,Class<T> responseClass) throws HttpErrorCodeException {
		if(logger.isDebugEnabled()){
			logger.debug("post url is "+url+",post parameter is "+obj);
		}
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().post(Entity.entity(obj, MediaType.APPLICATION_JSON));
        try {
        	String res=response.readEntity(String.class);
            if (response.getStatus() != 200) {
                throw new HttpErrorCodeException("Failed with HTTP error code : " + response.getStatus()+",error message:"+res);
            }
    		if(logger.isDebugEnabled()){
    			logger.debug("Successfully got result: " +res );
    		}
            return  JSON.parseObject(res, responseClass);
        }finally {
            response.close();
            client.close();
        }
    }
    /**
	 * 
	 * @param url 请求的url
	 * @return  参数封装的json对象
	 * @throws HttpErrorCodeException
	 */
    public static <T>T get(String url,Class<T> responseClass) throws HttpErrorCodeException {
		if(logger.isDebugEnabled()){
			logger.debug("Get url is " + url);
		}
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request().get();
        try {
        	String res=response.readEntity(String.class);
            if (response.getStatus() != 200) {
                throw new HttpErrorCodeException("Failed with HTTP error code : " + response.getStatus()+",error message:"+res);
            }
    		if(logger.isDebugEnabled()){
    			logger.debug("Successfully got result: " +res );
    		}
            return JSON.parseObject(res, responseClass);
        } finally {
            response.close();
            client.close();
        }
    }
  
}

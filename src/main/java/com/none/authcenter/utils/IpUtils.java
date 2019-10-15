package com.none.authcenter.utils;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
	public static String getRemoteAddress(HttpServletRequest request) {  
		if(request==null){
			return null;
		}
        String ip = request.getHeader("X-Forwarded-For");    
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {    
            ip = request.getHeader("Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {    
            ip = request.getHeader("WL-Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {    
            ip = request.getRemoteAddr();    
        }    
        return ip;    
    }  
}

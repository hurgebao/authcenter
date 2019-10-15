package com.none.authcenter.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MonitorUtil {
	public static String getIp() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress().toString(); // 获取本机ip
		System.out.println("本机ip地址:" + ip);
		return ip;
	}

	public static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		// 获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(addr).getHardwareAddress();
		// System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// 字节转换为整数
			int temp = mac[i] & 0xff;
			String str = Integer.toHexString(temp);
			// System.out.println("每8位:"+str);
			if (str.length() == 1) {
				sb.append("0" + str);
			} else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:" + sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}

	public static void main(String[] args) throws Exception {
		getIp();
		getLocalMac();
	}
}

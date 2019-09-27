package com.none.authcenter.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class STD3DesUtil {
	/**
	 * 加密   先加密再转为base64编码
	 * @param keyStr
	 * @param dataStr
	 * @return
	 * @throws Exception
	 */
	public static String des3EncodeECBBase64String(String keyStr,String dataStr) throws Exception{
		byte[] data = dataStr.getBytes("UTF-8");
		byte[] key = keyStr.getBytes();
		byte[] result = des3EncodeECB(key, data);
		return  Base64.encodeBase64String(result);
	}
	/**
	 * 解密  先将base64字符串转换再解密
	 * @param keyStr
	 * @param base64DataStr
	 * @return
	 * @throws Exception
	 */
	public static String des3DecodeECBBase64String(String keyStr,String base64DataStr) throws Exception{
		byte[] data = Base64.decodeBase64(base64DataStr);
		byte[] key = keyStr.getBytes();
		byte[] result = des3DecodeECB(key, data);
		return new String(result, "UTF-8");
	}

	/**
	 * ECB加密,不要IV
	 *
	 * @param key
	 *            密钥
	 * @param data
	 *            明文
	 * @return Base64编码的密�?
	 * @throws Exception
	 */
	public static byte[] des3EncodeECB(byte[] key, byte[] data) throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] bOut = cipher.doFinal(data);

		return bOut;
	}

	/**
	 * ECB解密,不要IV
	 *
	 * @param key
	 *            密钥
	 * @param data
	 *            Base64编码的密�?
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] des3DecodeECB(byte[] key, byte[] data) throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/ECB/PKCS5Padding");

		cipher.init(Cipher.DECRYPT_MODE, deskey);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}

	/**
	 * CBC加密
	 *
	 * @param key
	 *            密钥
	 * @param keyiv
	 *            IV
	 * @param data
	 *            明文
	 * @return Base64编码的密�?
	 * @throws Exception
	 */
	public static byte[] des3EncodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] bOut = cipher.doFinal(data);

		return bOut;
	}

	/**
	 * CBC解密
	 *
	 * @param key
	 *            密钥
	 * @param keyiv
	 *            IV
	 * @param data
	 *            Base64编码的密�?
	 * @return 明文
	 * @throws Exception
	 */
	public static byte[] des3DecodeCBC(byte[] key, byte[] keyiv, byte[] data) throws Exception {

		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(key);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede" + "/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(keyiv);

		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

		byte[] bOut = cipher.doFinal(data);

		return bOut;

	}

}
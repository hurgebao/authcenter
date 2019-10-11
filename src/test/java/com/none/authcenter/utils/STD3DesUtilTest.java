package com.none.authcenter.utils;
import com.none.authcenter.utils.STD3DesUtil;
import org.junit.Test;
public class STD3DesUtilTest {

	String key="f510b8737344cddbca1c8564";
	@Test
	public void test3() throws Exception {
		String data="TAOBAOB083FE703F1F20201008";
		String encString= STD3DesUtil.des3EncodeECBBase64String(key, data);
		System.out.println("encString:"+encString);
		String desString=STD3DesUtil.des3DecodeECBBase64String(key, encString);
		System.out.println("desString:"+desString);
	}
	@Test
	public void test1() throws Exception {
		String encString="kQloZ7XcowZJnJfUBIf5R/gZ/Z22Ys1nsxp2inVLiRnTdYXxe+/U431Vo1n5qoYIb4dcP48doPD6MkgeIUIEDg==";
		String desString=STD3DesUtil.des3DecodeECBBase64String(key, encString);
		System.out.println("desString:"+desString);
	}
}	

package com.lei.config;

import javax.swing.text.StyledEditorKit.BoldAction;

/**
 * GeetestWeb配置文件
 * QQ:741047261
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "be1a5f7ab5958917609a87b5f76c70cd";
	private static final String geetest_key = "b32b6cc31c3fbc90d53a38ca9cbe3243";
	private static final boolean newfailback = true;

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}
	
	public static final boolean isnewfailback() {
		return newfailback;
	}

}

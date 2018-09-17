package com.lei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lei.config.GeetestConfig;
import com.lei.sdk.GeetestLib;
/**
 * 
 * Author: pibigstar
 * Created on: 2017年8月25日 上午11:14:10
 * QQ:741047261
 */

public class StartCaptchaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(), GeetestConfig.isnewfailback());
		String resStr = "{}";
		
		//自定义userid
		String userid = "test";
		//进行验证预处理
		int gtServerStatus = gtSdk.preProcess(userid);
		
		//将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
		//将userid设置到session中
		request.getSession().setAttribute("userid", userid);
		
		resStr = gtSdk.getResponseStr();
		PrintWriter out = response.getWriter();
		out.println(resStr);
	}
}
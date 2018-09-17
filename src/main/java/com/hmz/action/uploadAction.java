package com.hmz.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/uploadAction")
public class uploadAction {
    @RequestMapping("/img")
    @ResponseBody
    public String uploadImg(@RequestParam("image") String imgStr, HttpSession session) {

        String filePath = null;
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();

        filePath = session.getServletContext().getRealPath("/upload");
        //不存在就创建
        File file = new File(filePath);
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("文件夹不存在");
            file.mkdir();
        }

        filePath = filePath + "\\" + uuid + ".jpg";
        try {
            //俩种方式解密Base64 后者更简单
		/*	// Base64
			byte[] b;
				b = decoder.decodeBuffer(imgStr.split(",")[1]);

				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {
						b[i] += 256;
					}
				}
				*/
            //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
            byte[] b = Base64Utils.decodeFromString(imgStr.split(",")[1]);
            System.out.println(filePath);
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
            String json = "{\"result\":\"服务器异常\"}";
            return json;
        }
        String imgePath = "upload/" + uuid + ".jpg";
        String json = "{\"result\":\"ok\",\"file\":\""+imgePath+"\"}";
        System.out.println(json);
        return json;
    }
}
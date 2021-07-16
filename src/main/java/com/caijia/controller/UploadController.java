package com.caijia.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caijia.framework.ModelAndView;
import com.caijia.framework.PostMapping;

public class UploadController {

	@PostMapping("/upload/file")
	public ModelAndView doUpload(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 读取Request Body:
		InputStream input = req.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		for (;;) {
			int len = input.read(buffer);
			if (len == -1) {
				break;
			}
			output.write(buffer, 0, len);
		}
		// TODO: 写入文件:
		// 显示上传结果:
		String uploadedText = output.toString(StandardCharsets.UTF_8);
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Uploaded:</h1>");
		pw.write("<pre><code>");
		pw.write(uploadedText);
		pw.write("</code></pre>");
		pw.flush();
		return null;
	}

}

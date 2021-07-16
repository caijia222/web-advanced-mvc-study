package com.caijia.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caijia.framework.GetMapping;
import com.caijia.framework.ModelAndView;

public class CacheController {

	@GetMapping("/slow/hello")
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		// 模拟耗时1秒:
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Hello,World!</h1>");
		pw.flush();
		return null;
	}
}

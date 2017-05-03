package com.test.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/initFileUpload")
	public String initFileUpload() {
		return "FileUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String fileUpLoad(String name, @RequestParam("file") CommonsMultipartFile file, HttpSession session) {
		if (!file.isEmpty()) {
			String path = session.getServletContext().getRealPath("/upload/");
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			System.out.println("-----" + fileName);
			File targetFile = new File(path, new Date().getTime() + fileType);
			try {
				file.getFileItem().write(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "FileUpload";
	}

	@RequestMapping(value = "/fileDownLoad", method = RequestMethod.GET)
	public void fileDownLoad(HttpSession session, HttpServletResponse response, String fileName, boolean isOnline)
			throws Exception {
		String path = session.getServletContext().getRealPath("/upload/") + "\\" + fileName;
		File file = new File(path);
		System.out.println(path);
		if (!file.exists()) {
			response.sendError(404, "您要下载的文件没找到");
			return;
		}
		BufferedInputStream bufIn = new BufferedInputStream(new FileInputStream(file));
		byte[] buff = new byte[1024];
		int len = -1;
		response.reset();
		if (isOnline) {
			URL u = new URL("file:///" + path);
			response.setContentType(u.openConnection().getContentType());
			response.setHeader("Content-Disposition", "inline;filename=" + fileName);

		} else {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		}
		OutputStream out = response.getOutputStream();
		while ((len = bufIn.read(buff)) != -1) {
			out.write(buff, 0, len);
			out.flush();
		}
		bufIn.close();
		out.close();
	}

}

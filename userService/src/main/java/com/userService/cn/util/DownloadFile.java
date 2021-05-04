package com.userService.cn.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**   
 * @ClassName: DownloadFile   
 * @Description: 附件下载
 * @author: 王强
 * @date: 2020年4月15日 上午3:25:04     
 */
public class DownloadFile {
	private static final String ENCODED="UTF-8";
	
	private static void fileStream(HttpServletResponse response,InputStream in) throws Exception {
		BufferedInputStream bs=new BufferedInputStream(in);
		int len=0;
		byte[] bytes=new byte[1024];
		OutputStream out=response.getOutputStream();
		try {
			while ((len=bs.read(bytes))>0) {
				out.write(bytes, 0, len);
			}
		} finally {
			out.flush();
			out.close();
			bs.close();
			in.close();
		}
	}
	
	/**   
	 * @Title: downloadFileStream 
	 * @Description: 通过IO流下载
	 * @param response
	 * @param in 文件流
	 * @param fileName 文件名称
	 * @throws Exception
	 * @return: void
	 * @throws  
	 */
	public static void downloadFileStream(HttpServletResponse response,InputStream in,String fileName) throws Exception {
		response.setContentType("application/x-msdownload");
		fileName= URLEncoder.encode(fileName, ENCODED);
		response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
		fileStream(response, in);
		
		
	}

	/**   
	 * @Title: downloadFile 
	 * @Description: 在线文件打开或下载
	 * @param response
	 * @param filePath 目标文件路径
	 * @param isOnLine true:在线打开,false:在线下载
	 * @param fileName 文件名称
	 * @throws Exception
	 * @return: void
	 * @throws  
	 */
	public static void downloadFile(HttpServletResponse response, String filePath, boolean isOnLine,
			String fileName) throws Exception {
		
		// 判断是本地路径或者网络路径，获取相应的ContentType
		String contentType = null;
		URL url=null;
		if (filePath.startsWith("http")) {
			url = new URL(filePath);
		} else {
			url = new URL("file:///" + filePath);// 本地路径要加协议file:///
		}
		URLConnection urlConnection= url.openConnection();
		contentType=urlConnection.getContentType();
		// 清空response
		response.reset();
		fileName = URLEncoder.encode(fileName, ENCODED);
		if (isOnLine) {
			// 在线打开
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "inline;filename=" + fileName);
		} else {
			// 在线下载
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		}
		fileStream(response, urlConnection.getInputStream());
	}
}

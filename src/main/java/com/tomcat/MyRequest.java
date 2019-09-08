package com.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
	private String url;
	private String method;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public MyRequest(InputStream inputStream) throws IOException {
		int length=0;
		String httpServlet="";
		byte[] httpServletBytes=new byte[1024];
		if((length=inputStream.read(httpServletBytes))>0) {
			httpServlet = new String(httpServletBytes,0,length);
		}
		String httpHead = httpServlet.split("\n")[0];
		String[] split = httpHead.split(" ");
		if(split!=null) {
			System.out.println(split.toString());
			method = split[0];
			url = split[1];
		}
		System.out.println(this);
	}
	
}

package com.tomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}
	public void write(String content) throws IOException {
		File file = new File(content);
		FileInputStream fileInputStream=null;
		byte[] fileBytes=new byte[1024];
		String fileHttpResponse=null;
		int length=0;
		if(file.isFile()) {
			fileInputStream = new FileInputStream(file.getPath());
			if((length=fileInputStream.read(fileBytes))>0) {
				fileHttpResponse = new String(fileBytes,0,length);
			}
		}
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("HTTP/1.1 200 OK\n")
		.append("Content-Type: text/html\n")
		.append("\r\n")
		.append("<html><body>")
		.append(1)
		.append("</body></html>");
//		outputStream.write("HTTP/1.1 200 OK\n".getBytes());
//		outputStream.write("Content-Type: text/html\n".getBytes());
//		outputStream.write("\r\n".getBytes());
		outputStream.write(stringBuffer.toString().getBytes());
		if(fileHttpResponse!=null) {
			outputStream.write(fileHttpResponse.getBytes());
			
		}
		outputStream.close();
	}
}

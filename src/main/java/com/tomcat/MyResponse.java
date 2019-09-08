package com.tomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
	private OutputStream outputStream;

	public MyResponse(OutputStream outputStream) {
		super();
		this.outputStream = outputStream;
	}
	public void write(String content) throws IOException {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("HTTP/1.1 200 OK\n")
		.append("Content-Type: text/html\n")
		.append("\r\n")
		.append("<html><body>")
		.append(content)
		.append("</body></html>");
		outputStream.write(stringBuffer.toString().getBytes());
		outputStream.close();
	}
}

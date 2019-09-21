package com.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {
	public int port=8080;
	public static Map<String,String> servletMap=new HashMap<String, String>();
	public MyTomcat(int port){
		this.port=port;
	}
	public void start() {
		initServletMapping();
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("myTomcat start....");
			while(true) {
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);
				dispatch(myRequest,myResponse);
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(serverSocket!=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//今天天气很好1
	private void dispatch(MyRequest myRequest, MyResponse myResponse){
		String clazz = servletMap.get(myRequest.getUrl());
		if(clazz!=null) {
			try {
				Class<MyServlet> myServlet = (Class<MyServlet>) Class.forName(clazz);
				MyServlet newInstance = myServlet.newInstance();
				newInstance.service(myRequest, myResponse);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void initServletMapping() {
		// TODO Auto-generated method stub
		for (ServletMapping servletMapping : ServletMappingConfig.servletList) {
			servletMap.putIfAbsent(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
}

package com.tomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
	public static List<ServletMapping> servletList=new ArrayList<ServletMapping>();
	static {
		servletList.add(new ServletMapping("findGirlServlet", "/girl", "com.tomcat.FindGirlServlet"));
		servletList.add(new ServletMapping("helloWorldServlet", "/world", "com.tomcat.HelloWorldServlet"));
	}
}

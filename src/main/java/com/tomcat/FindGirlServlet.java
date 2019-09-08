package com.tomcat;

import java.io.IOException;

public class FindGirlServlet extends MyServlet{

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse) {
		try {
			myResponse.write("girl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse) {
		// TODO Auto-generated method stub
		try {
			myResponse.write("../com/target/test.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

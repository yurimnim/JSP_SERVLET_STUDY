package com.bit.bitService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BitService {
	public String service(HttpServletRequest request, HttpServletResponse response);
	
}

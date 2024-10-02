package com.soun.exam;

import jakarta.servlet.http.HttpServlet;

	public class LifecycleServlet extends HttpServlet {
	    private static final Logger logger = Logger.getLogger(LifecycleServlet.class.getName());

	    public void init() throws ServletException {
	        logger.info("서블릿 초기화됨: " + this.getServletName());
	    }

	    protected void service(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        logger.info("서비스 메소드 호출됨: " + request.getMethod());
	        super.service(request, response);
	    }

	    public void destroy() {
	        logger.info("서블릿 소멸됨: " + this.getServletName());
	    }
	}


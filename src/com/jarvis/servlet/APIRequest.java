package com.jarvis.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jarvis.util.APIResponseParser;
import com.jarvis.util.HttpUtility;

/**
 * Servlet implementation class APIRequest
 */
public class APIRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String requestApi(String q) throws UnsupportedEncodingException {
		// test sending GET request
		q = URLEncoder.encode(q, "UTF-8");
		String allines = "";
		String requestURL = "https://api.projectoxford.ai/luis/v1/application?id=e099b495-7002-453b-995a-cefd365c7100&subscription-key=59133f6acce54184a8e45eafcc037872&q="+q;
		try {
			HttpUtility.sendGetRequest(requestURL);
			String[] response = HttpUtility.readMultipleLinesRespone();
			for (String line : response) {
				allines += line;
				//System.out.println(line);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		HttpUtility.disconnect();
		return allines;
	}   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APIRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String q = request.getParameter("uname");
		System.out.println("JARVIS HERE " + q);
		String s = requestApi(q);
		APIResponseParser.getResponseOnject(s);
		response.getWriter().write(s);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

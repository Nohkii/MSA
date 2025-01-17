package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet("/basket3")
public class BasketServlet3 extends HttpServlet {
	@SuppressWarnings("unchecked") // 제너릭스를 쓰지않아서..?어노테이션을 써줘야한다,,
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		int productnum = 1;
		HttpSession session = request.getSession();

		if (pid == null) {
			session.invalidate();
			out.println("<h1>선택한 상품이 없습니다.</h1>");
			out.println("-----------------------------------");
			out.print("<a href='" + "/edu/clientexam/productlog2.html" + "'>상품선택화면&nbsp</a>");
			out.close();
			return;
		}
		   if (session.getAttribute("cnt") == null) {
	            session.setAttribute("cnt", new JSONObject());
	        }

	        productnum = Integer.parseInt(pid.substring(2));
	        JSONObject count = (JSONObject) session.getAttribute("cnt");

	        // 선택한 상품에 대한 처리 (count를 업데이트)
	        if (count.containsKey("p" + productnum)) {
	            int currentCount = Integer.parseInt(count.get("p" + productnum).toString());
	            count.put("p" + productnum, currentCount + 1);
	        } else {
	            count.put("p" + productnum, 1);
	        }

	        // 세션에 업데이트된 JSON 객체를 저장
	        session.setAttribute("cnt", count);

	        // 클라이언트로 업데이트된 JSON 객체를 반환
	        out.print(count.toJSONString());
	        out.flush();
	        out.close();
		/*
		 * if (session.getAttribute("cnt") == null) { session.setAttribute("cnt", new
		 * int[10]); }
		 * 
		 * productnum = Integer.parseInt(pid.substring(2)); int[] count = (int[])
		 * session.getAttribute("cnt"); System.out.println(productnum); count[productnum
		 * - 1]++;
		 * 
		 * JSONObject jsonObj = new JSONObject(); for (int i = 0; i < count.length; i++)
		 * { if (count[i] != 0) { jsonObj.put("p" + (i + 1), count[i]); } }
		 * session.setAttribute("cnt", jsonObj);
		 * response.setContentType("application/json");
		 * response.setCharacterEncoding("UTF-8"); out.print(jsonObj.toJSONString());
		 * out.flush(); out.close();
		 */
	}
}
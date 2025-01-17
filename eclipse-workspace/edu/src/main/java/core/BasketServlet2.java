package core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket2")
public class BasketServlet2 extends HttpServlet {
	int[] ary = new int[10];
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("selectedImgName");
		// if문으로 돌리면서 들어온 글자랑 일치하면 +1을하려고 했던 생각인듯,,?
		switch((String) session.getAttribute("selectedImgName")) {
		case "pid01" :
			ary[0]++;
			break;
		case "pid02" :
			ary[1]++;
			break;
		}
		// 이름 배열을 만들거나 /switch로 돌리거나
		/*
		 * for (int i = 0; i < 10; i++) { ary[i] = (int)
		 * session.getAttribute("selectedImgName"); // 세션에서 "cnt" 속성을 얻어와서 count 배열에 할당
		 * ary[i]++; }
		 */
		/* String selectedImgName = (String) session.getAttribute("selectedImgName"); */
		out.print("<h2>선택한 상품 리스트</h2>");
		out.print("-------------------------------------------");
		if (session.getAttribute("selectedImgName") != null) {
			out.print("<ul/>");
			for (int i = 0; i < ary.length; i++) {
				// if 값이 0이면 패스?
				out.print("<li/>");
				out.print("p0" + i + " 상품 " + ary[i] + "개");
				out.print("</li>");
			}
			out.print("</ul>");
		} else {
			out.print("<h3/>선택한 상품이 없습니다.</h3>");
		}
		out.print("<a href='" + request.getHeader("referer") + "'>상품선택화면</a>");
		out.close();
	}
}

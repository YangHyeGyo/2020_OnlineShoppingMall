package servletTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		
		String NAME = request.getParameter("NAME");
		ProductVO param = new ProductVO();
		param.setNAME(NAME);
		ProductVO vo = dao.product(param);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);

		
	}
}

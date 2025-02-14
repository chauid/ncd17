package shop.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shop.data.ShopDao;
import shop.data.ShopDto;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/shop/list")
public class ListServlet extends HttpServlet {
	
	ShopDao dao=new ShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//전체갯수 가져오기
		int totalCount=dao.getTotalCount();
		//전체 상품목록 가져오기
		List<ShopDto> list=dao.getAllDatas();
		
		//request 에 저장
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		//포워드
		RequestDispatcher rd=request.getRequestDispatcher("./shoplist.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

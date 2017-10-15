package sys_bs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sys_bs.entity.Account;
import sys_bs.service.ILoginService;
import sys_bs.service.Impl.LoginServiceImpl;



/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoginService iloginService=new LoginServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		HttpSession session=request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String codes=request.getParameter("code");
		String passwords=request.getParameter("password");
		boolean flag=iloginService.Login(codes, passwords);
		Account account = new Account();
	//	Account account = new Account();
		if(flag){
			session.setAttribute("code1", codes);
			session.setAttribute("password1", passwords);
			//List<Account> listAccount=new ArrayList<Account>();
			List<Account> listAccount=iloginService.listAccount(account);
			session.setAttribute("list", listAccount);
			PrintWriter pw=response.getWriter();
			pw.write("0");
			return;
		}
		PrintWriter pw=response.getWriter();
		pw.write("1");
		return;
	}

}


package sys_bs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sys_bs.entity.Account;
import sys_bs.entity.ClassRoom;
import sys_bs.service.StudentService;
import sys_bs.service.Impl.StudentServiceImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentService studentService = new StudentServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("utf-8");
		String flags=request.getParameter("flag");
		boolean flag=false;
		HttpSession session = request.getSession();
		Account account = new Account();
		account.setId(request.getParameter("id"));
		if("4".equals(flags)){
			String codes=request.getParameter("code");
			String passwords=request.getParameter("password");
			boolean sys=studentService.login(codes, passwords);
			if(sys){
				session.setAttribute("code1", codes);
				session.setAttribute("password1", passwords);
				List<Account> listAccount=studentService.listAccount(account);
				session.setAttribute("list", listAccount);
				PrintWriter pw=response.getWriter();
				pw.write("0");
				return;
			}
			PrintWriter pw = response.getWriter();
			pw.write("1");
			return;
		}
		if("0".equals(flags)){
			List<Account> listAccount = studentService.listAccount(account);
			//Account accounts = listAccount.get(0);
			Account Acc = listAccount.get(0);
			session.setAttribute("account", Acc);
			session.setAttribute("list", listAccount);
			PrintWriter pw = response.getWriter();
			pw.write("0");
			return;
		}
		if("1".equals(flags)){
			account.setCode(request.getParameter("code"));
			account.setName(request.getParameter("name"));
			account.setPassword(request.getParameter("password"));
			account.setSex(request.getParameter("sex"));
			account.setAge(request.getParameter("age"));
			flag=studentService.addStudent(account);
			if(flag){
				PrintWriter pw = response.getWriter();
				pw.write("0");
				return;
			}
		}
		if("2".equals(flags)){
			flag=studentService.deleteStudent(account);
			if(flag){
				PrintWriter pw = response.getWriter();
				pw.write("0");
				return;
			}
		}
		if("3".equals(flags)){
			account.setName(request.getParameter("name"));
			account.setPassword(request.getParameter("password"));
			account.setSex(request.getParameter("sex"));
			account.setAge(request.getParameter("age"));
			flag=studentService.updateStudent(account);
			if(flag){
				PrintWriter pw = response.getWriter();
				pw.write("0");
				return;
			}
		}
		PrintWriter pw = response.getWriter();
		pw.write("1");
		return;
	}

}

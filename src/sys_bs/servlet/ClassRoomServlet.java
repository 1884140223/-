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


import sys_bs.entity.ClassRoom;
import sys_bs.service.ClassRoomService;
import sys_bs.service.Impl.ClassRoomServiceImpl;

/**
 * Servlet implementation class ClassRoomServlet
 */
@WebServlet("/ClassRoomServlet")
public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ClassRoomService ClassService = new ClassRoomServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomServlet() {
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
		ClassRoom account = new ClassRoom();
		account.setId(request.getParameter("id"));
		/**
		 * 登录验证
		 */
		if("4".equals(flags)){
			String codes=request.getParameter("code");
			String passwords=request.getParameter("password");
			boolean sys=ClassService.login(codes, passwords);
			if(sys){
				session.setAttribute("code1", codes);
				session.setAttribute("password1", passwords);
				List<ClassRoom> listAccount=ClassService.listAccount(account);
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
			List<ClassRoom> listAccount = ClassService.listAccount(account);
			//Account accounts = listAccount.get(0);
			ClassRoom Classroom = listAccount.get(0);
			session.setAttribute("account", Classroom);
			session.setAttribute("list", listAccount);
			PrintWriter pw = response.getWriter();
			pw.write("0");
			return;
		}
		if("1".equals(flags)){
			account.setId(request.getParameter("id"));
			account.setCode(request.getParameter("code"));
			account.setPassword(request.getParameter("password"));
			account.setLei(request.getParameter("lei"));
			account.setNumber(request.getParameter("number"));
			account.setTeacher(request.getParameter("teacher"));
			flag=ClassService.addClassRoom(account);
			if(flag){
				PrintWriter pw = response.getWriter();
				pw.write("0");
				return;
			}
		}
		if("2".equals(flags)){
			flag=ClassService.deleteClassRoom(account);
			if(flag){
				PrintWriter pw = response.getWriter();
				pw.write("0");
				return;
			}
		}
		if("3".equals(flags)){
			account.setCode(request.getParameter("code"));
			account.setPassword(request.getParameter("password"));
			account.setLei(request.getParameter("lei"));
			account.setNumber(request.getParameter("number"));
			account.setTeacher(request.getParameter("teacher"));
			flag=ClassService.updateClassRoom(account);
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

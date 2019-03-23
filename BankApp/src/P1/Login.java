package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet 
{
	public void service(HttpServletRequest request,HttpServletResponse response){
		try {
		String custid=request.getParameter("custid");
		String pwd=request.getParameter("pwd");
		
		Model m=new Model();//place cursor and import model package
		m.setCustid(custid);
		m.setPwd(pwd);
		
		boolean status=m.login();
		if(status==true)
		{
			HttpSession session=request.getSession(true);
			String ACCNO=m.getAccno();
			System.out.println(ACCNO);
			session.setAttribute("accno", ACCNO);
			response.sendRedirect("/BANK_APP/home.jsp");
		}
		else
		{
			response.sendRedirect("/BANK_APP/loginFail.jsp");
		}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package test;

import com.neuedu.Utils.ObTime;
import com.neuedu.Utils.ProUtil;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Longin3Servlet",urlPatterns = "/lo")
public class Longin3Servlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String psw = req.getParameter("psw");

        User user = new User(ProUtil.getProId(),username,psw,ProUtil.getStringForDate(ObTime.ObtainDate()));

        Boolean boo = ud.SingUser(user);

        if (boo == true)
        {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60);

            req.getRequestDispatcher("wco.jsp").forward(req,resp);

        }else
        {
            req.getRequestDispatcher("Longin2.jsp").forward(req,resp);
        }
    }

}

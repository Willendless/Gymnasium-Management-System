package project.servlet;

import project.bean.Reserve;
import project.bean.StadiumPlan;
import project.dao.*;
import project.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseForeServlet")
public class BaseForeServlet extends HttpServlet {
    //日期格式
    protected final static String A="yyyy-MM-dd";
    protected final static String B="yyyy-MM-dd HH:mm:ss";
    protected final static String C="yyyy/MM/dd HH:mm:ss";

    //数据处理实体类
    protected UserDAO userDAO = new UserDAO();
    protected PlaceDAO placeDAO = new PlaceDAO();
    protected PlaceStadiumDAO placeStadiumDAO = new PlaceStadiumDAO();
    protected StadiumPlanDAO stadiumPlanDAO = new StadiumPlanDAO();
    protected StadiumPlanItemDAO stadiumPlanItemDAO = new StadiumPlanItemDAO();
    protected ReserveDAO reserveDAO = new ReserveDAO();
    protected NewsDAO newsDAO = new NewsDAO();
    protected ReserveItemDAO reserveItemDAO = new ReserveItemDAO();

    public void service(HttpServletRequest request, HttpServletResponse response) {
        try {

            int start= 0;
            int count = 10;
            try {
                start = Integer.parseInt(request.getParameter("page.start"));
            } catch (Exception e) {

            }

            try {
                count = Integer.parseInt(request.getParameter("page.count"));
            } catch (Exception e) {
            }

            Page page = new Page(start,count);

            String method = (String) request.getAttribute("method");

            Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
                    javax.servlet.http.HttpServletResponse.class,Page.class);

            String redirect = m.invoke(this,request, response,page).toString();

            if(redirect.startsWith("@"))    //页面跳转，浏览器中地址改变
                response.sendRedirect(redirect.substring(1));
            else if(redirect.startsWith("%"))
                response.getWriter().print(redirect.substring(1));
            else    //浏览器中地址不变
                request.getRequestDispatcher(redirect).forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

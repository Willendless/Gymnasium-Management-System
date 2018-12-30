package project.servlet;

import project.bean.Place;
import project.bean.PlaceStadium;
import project.bean.StadiumPlan;
import project.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StadiumPlanServlet extends BaseBackServlet{
    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }
    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }
    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        int psid = Integer.parseInt(request.getParameter("psid"));

        Enumeration all = request.getParameterNames();
        try {
            while (all.hasMoreElements()) {
                String s = (String)all.nextElement();
                if (s.equals("pid") || s.equals("psid") || s.equals("date"))
                    continue;
                System.out.println(s);
                stadiumPlanItemDAO.edit(Integer.parseInt(s), new String(request.getParameter(s).getBytes("ISO-8859-1"), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "@admin_stadiumPlan_list?pid=" + pid + "&psid=" + psid + "&date=" + request.getParameter("date");
    }

    //列出pid场馆，psid场地，date日的安排列表
    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        Place place = placeDAO.get(pid);
        List<PlaceStadium> placeStadiums = placeStadiumDAO.list(pid);

        //获取场地id号
        int psid = Integer.parseInt(request.getParameter("psid"));
        if (psid == 0) {
            psid = placeStadiums.get(0).getId();
        }
        PlaceStadium placeStadium = placeStadiumDAO.get(psid);
        System.out.println("psid  "+psid);



        //获取请求日期
        String time = request.getParameter("date");
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        if (time != null) {
            date = java.sql.Date.valueOf(time);
        }


        //获取能获取的有效日期
        Date current = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(current);
        List<java.sql.Date> dateValid = new ArrayList<>();
        calendar.add(Calendar.DATE, 0);
        dateValid.add(new java.sql.Date(calendar.getTimeInMillis()));
        calendar.add(Calendar.DATE, 1);
        dateValid.add(new java.sql.Date(calendar.getTimeInMillis()));
        calendar.add(Calendar.DATE, 1);
        dateValid.add(new java.sql.Date(calendar.getTimeInMillis()));

        //获取所有场的安排表

        List<StadiumPlan> stadiumPlanList = stadiumPlanDAO.search(psid, date);

        if (stadiumPlanList == null)
            return "";

        request.setAttribute("placeStadium", placeStadium);
        request.setAttribute("place", place);
        request.setAttribute("placeStadiums", placeStadiums);
        request.setAttribute("stadiumPlanList", stadiumPlanList);
        request.setAttribute("dates", dateValid);
        request.setAttribute("date", date);
        request.setAttribute("name", placeStadium.getName());

        return "admin/listStadiumPlan.jsp";
    }

}

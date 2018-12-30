package project.servlet;

import org.omg.PortableInterceptor.INACTIVE;
import project.bean.Place;
import project.bean.PlaceStadium;
import project.dao.PlaceDAO;
import project.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaceStadiumServlet extends BaseBackServlet{
    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String, String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        PlaceStadium placeStadium = new PlaceStadium();
        placeStadium.setName(params.get("name"));
        placeStadium.setNum(Integer.parseInt(params.get("num")));
        placeStadium.setFare(Integer.parseInt(params.get("fare")));
        int pid = Integer.parseInt(request.getParameter("pid"));
        placeStadium.setPlace(placeDAO.get(pid));

        placeStadiumDAO.add(placeStadium);
        return "@admin_placeStadium_list?pid=" + pid;
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        placeStadiumDAO.delete(Integer.parseInt(request.getParameter("id")));
        return "@admin_placeStadium_list?pid=" + pid;
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        Place place = placeDAO.get(Integer.parseInt(request.getParameter("pid")));
        PlaceStadium placeStadium = placeStadiumDAO.get(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("placeStadium", placeStadium);
        request.setAttribute("place", place);
        return "admin/editPlaceStadium.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        PlaceStadium placeStadium = placeStadiumDAO.get(Integer.parseInt(request.getParameter("id")));
        Map<String, String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        placeStadium.setName(params.get("name"));
        placeStadium.setNum(Integer.parseInt(params.get("num")));
        placeStadium.setFare(Integer.parseInt(params.get("fare")));
        placeStadiumDAO.update(placeStadium);
        int pid = Integer.parseInt(request.getParameter("pid"));
        return "@admin_placeStadium_list?pid=" + pid;
    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        List<PlaceStadium>  placeStadiums = placeStadiumDAO.list(pid);
        request.setAttribute("placeStadiums", placeStadiums);
        request.setAttribute("place", placeDAO.get(pid));
        return "admin/listPlaceStadium.jsp";
    }

}

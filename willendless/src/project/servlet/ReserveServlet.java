package project.servlet;

import project.bean.Reserve;
import project.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ReserveServlet extends BaseBackServlet {

    //无add操作
    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        return "#";
    }
    //需要修改
    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        return null;
    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {

        List<Reserve> reserveList = reserveDAO.list(page.getStart(), page.getCount());
        int total = reserveDAO.getTotal();
        page.setTotal(total);
        for (int i = 0; i < reserveList.size(); i++) {
            reserveItemDAO.fill(reserveList.get(i));
        }
        request.setAttribute("reserveList", reserveList);
        request.setAttribute("page", page);
        return "admin/listReserve.jsp";
    }

    /*提交后：安排项修改为：未付款，订单修改为未付款*/
    //审核通过：安排表项修改为：，订单修改为占用
    public String pass(HttpServletRequest request, HttpServletResponse response, Page page) {
        int rid = Integer.parseInt(request.getParameter("rid"));
        reserveDAO.edit(rid, "审核通过");
        Reserve reserve = new Reserve();
        reserve.setId(rid);
        reserveItemDAO.fill(reserve);
        for (int i = 0; i < reserve.getReserveItemList().size(); i++) {
            stadiumPlanItemDAO.edit(reserve.getReserveItemList().get(i).getStadiumPlanItem().getId(), "占用");
        }
        return "@admin_reserve_list";
    }

    //审核失败：安排表项修改为：空闲，订单修改为审核未通过
    public String fail(HttpServletRequest request, HttpServletResponse response, Page page) {
        int rid = Integer.parseInt(request.getParameter("rid"));
        reserveDAO.edit(rid, "审核未通过");
        Reserve reserve = new Reserve();
        reserve.setId(rid);
        reserveItemDAO.fill(reserve);
        for (int i = 0; i < reserve.getReserveItemList().size(); i++) {
            stadiumPlanItemDAO.edit(reserve.getReserveItemList().get(i).getStadiumPlanItem().getId(), "空闲");
        }
        return "@admin_reserve_list";
    }

}

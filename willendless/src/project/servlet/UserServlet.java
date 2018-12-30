package project.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import project.bean.User;
import project.util.Page;

import org.springframework.web.util.HtmlUtils;

public class UserServlet extends BaseBackServlet {
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
        return null;
    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<User> us = userDAO.list(page.getStart(), page.getCount());
        int total = userDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("us", us);
        request.setAttribute("page", page);

        return "admin/listUser.jsp";
    }
}

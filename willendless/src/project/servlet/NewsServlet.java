package project.servlet;

import project.bean.News;
import project.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "NewsServlet")
public class NewsServlet extends BaseBackServlet {
    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {

        Map<String, String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        News news = new News();
        news.setTitle(params.get("title"));
        news.setContent(params.get("content"));
        news.setTime(new Date(System.currentTimeMillis()));

        newsDAO.add(news);
        return "@admin_news_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int nid = Integer.parseInt(request.getParameter("nid"));
        newsDAO.delete(nid);
        return "@admin_news_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(id);
        request.setAttribute("news", news);
        return "admin/editNews.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        News news = newsDAO.get(Integer.parseInt(request.getParameter("id")));
        Map<String, String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        news.setTitle(params.get("title"));
        news.setContent(params.get("content"));
        newsDAO.update(news);
        return "@admin_news_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<News> news = newsDAO.list(page.getStart(), page.getCount());
        int total = newsDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("news", news);
        request.setAttribute("page", page);

        return "admin/listNews.jsp";
    }
}

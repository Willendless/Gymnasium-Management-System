package project.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class News {
    private int id;
    private Date time;
    private String title;
    private String content;
    private String TIME;        //yyyy年MM月dd日
    private String TIMEX;       //yyyy-MM-dd HH:mm:ss

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    public String getTIMEX() {
        return TIMEX;
    }

    public void setTIMEX(String TIMEX) {
        this.TIMEX = TIMEX;
    }
}

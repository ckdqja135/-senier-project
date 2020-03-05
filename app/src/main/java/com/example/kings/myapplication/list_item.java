package com.example.kings.myapplication;
import java.util.Date;

public class list_item {
    private String title;
    private Date write_date;
    private String content;

    public list_item(String title, Date write_date, String content) {
        this.title = title;
        this.write_date = write_date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Date write_date) {
        this.write_date = write_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


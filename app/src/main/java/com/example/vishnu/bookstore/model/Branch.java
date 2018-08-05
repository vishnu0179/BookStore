package com.example.vishnu.bookstore.model;

/**
 * Created by Vishnu on 05/08/2018.
 */

public class Branch {



    public String subject;
    public String year;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public Branch(String subject, String year) {
        this.subject = subject;
        this.year = year;
    }

    public Branch() {
    }

}

package com.example.javatest.domain;

import com.example.javatest.study.StudyStatus;

import java.util.Optional;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;
    private String name;
    private Member member;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }

    public void setOwner(Member member) {
        this.member = member;
    }
}

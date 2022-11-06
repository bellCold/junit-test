package com.example.javatest;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;

    private int limit;

    public StudyStatus getStatus() {
        return status;
    }

    public int getLimit() {
        return limit;
    }
}

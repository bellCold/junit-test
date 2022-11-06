package com.example.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CustomTagTest {

    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void create() {
        System.out.println("create");
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void create1() {
        System.out.println("create1");
    }
}

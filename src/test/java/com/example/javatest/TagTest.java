package com.example.javatest;

import org.junit.jupiter.api.DisplayName;

public class TagTest {

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void create() {
        System.out.println("create");
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void create1() {
        System.out.println("create1");
    }
}

package com.example.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FindSlowTestExtension.class)
public class CustomTagTest {

    @Test
    @DisplayName("스터디 만들기 fast")
    @FastTest
    void create() {
        System.out.println("create");
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @SlowTest
    void create1() throws InterruptedException {
        Thread.sleep(1005L);
        System.out.println("create1");
    }
}

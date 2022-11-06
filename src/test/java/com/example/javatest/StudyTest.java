package com.example.javatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    @EnabledOnJre(JRE.JAVA_11)
    @EnabledOnOs(OS.MAC)
    void create() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            new Study(10, "김종찬");
            Thread.sleep(50);
        });

        Study study = new Study(10, "김종찬");
        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 + " + StudyStatus.DRAFT + "T여야 한다."),
                () -> assertEquals(10, study.getLimit(), "스터디 최대 참석 가능 인원은 0보다 커야한다")
        );
    }

    @Test
    @DisplayName("스터디1 만들기")
    void create1() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }
}
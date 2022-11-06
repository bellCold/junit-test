package com.example.javatest;

import com.example.javatest.domain.Study;
import com.example.javatest.study.StudyStatus;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyTest {

    int value = 1;

    @Order(2)
    @Test
    @DisplayName("스터디 만들기")
    void create() {
        System.out.println(value++);
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

    @Order(1)
    @Test
    @DisplayName("스터디1 만들기")
    void create1() {
        System.out.println("create1");
        System.out.println(value++);
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    void afterAll() {
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
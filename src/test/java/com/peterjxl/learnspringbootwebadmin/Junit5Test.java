package com.peterjxl.learnspringbootwebadmin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5Test {

    @Test
    @DisplayName("测试DisplayName")
    void testDisplayName(){
        System.out.println("testDisplayName");
    }

    @Test
    @DisplayName("测试方法2")
    @Disabled
    void test2(){
        System.out.println("test2");
    }

    @RepeatedTest(5)
    void test5(){
        System.out.println("test5");
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了.....");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了.....");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了.....");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试结束了.....");
    }
}

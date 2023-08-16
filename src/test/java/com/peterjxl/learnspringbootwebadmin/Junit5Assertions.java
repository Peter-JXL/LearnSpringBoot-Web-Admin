package com.peterjxl.learnspringbootwebadmin;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;


@SpringBootTest
public class Junit5Assertions {


    int calulate(int i, int j){
        return i + j;
    }

    @Test
    void testSimpleAssertions(){
        int calulate = calulate(3, 3);
        Assertions.assertEquals(5, calulate, "业务逻辑计算失败");
    }

    @Test
    public void array() {
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
        Assertions.assertArrayEquals(new int[]{2, 2}, new int[] {1, 2});
    }

    @Test
    @DisplayName("组合断言")
    void all() {
        Assertions.assertAll("test",
                () -> Assertions.assertTrue(true && true, "结果不为true"),
                () -> Assertions.assertEquals(1, 2, "结果不为1"));
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> System.out.println(1 % 0),
                "业务逻辑居然正常运行？");
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        Assertions.fail("This should fail");
    }
}

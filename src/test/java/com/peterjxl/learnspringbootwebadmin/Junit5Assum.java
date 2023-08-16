package com.peterjxl.learnspringbootwebadmin;


import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public class Junit5Assum {

    @Test
    @DisplayName("前置条件")
    void testAssum() {
        Assumptions.assumeTrue(false, "结果不为true");
        System.out.println("如果前置条件不成立，本句话就不输出");
    }

    @Test
    @DisplayName("assume then do")
    public void assumeThenDo() {
        String environment = "DEV";

        Assumptions.assumingThat(
                Objects.equals(environment, "DEV"),
                () -> System.out.println("In DEV")
        );
    }
}

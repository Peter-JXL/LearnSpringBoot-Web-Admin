package com.peterjxl.learnspringbootwebadmin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Junit5Para {

    @ParameterizedTest  //表明这是一个参数化测试
    @DisplayName("参数化测试")
    @ValueSource(ints = {1, 2, 3, 4, 5})  //指定参数
    void testParameterized(int i) {
        System.out.println(i);
    }

    static String[] stringProvider() {
        return new String[] { "apple", "banana", "sh*t"};
    }

    @ParameterizedTest  //表明这是一个参数化测试
    @DisplayName("参数化测试2")
    @MethodSource("stringProvider")  //指定参数
    void testParameterized2(String i) {
        System.out.println(i);
    }


}

package com.future.practice.global.constant;

import java.util.regex.Pattern;

public class Common {
    public static int BOARD_NUM = 10;
    public final static int PASSWORD_LENGTH = 4;
    public final static Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{4,20}$");// 영문 숫자 포함 확인
}

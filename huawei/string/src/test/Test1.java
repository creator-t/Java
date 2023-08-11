package test;

import org.junit.jupiter.api.Test;

/**
 * ClassName: Test1
 * Package: test
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/11 21:14
 * @Version 1.0
 */
public class Test1 {
    @Test
    void test1(){
//        String binary = Integer.toBinaryString(Character.digit('1', 16));

        int decimal = Character.digit('1', 16); // 获取字符的十进制值
        String binary = String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0');
        System.out.println(binary);
        String reversedBinary = new StringBuilder(binary).reverse().toString();
        System.out.println(reversedBinary);
        int reversedDecimal = Integer.parseInt(reversedBinary, 2);
        System.out.println(reversedDecimal);
        char hexChar = Character.toUpperCase(Integer.toHexString(reversedDecimal).charAt(0));
        System.out.println(hexChar);
    }
}

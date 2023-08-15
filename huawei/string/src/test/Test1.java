package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

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
    void test1() {
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

    @Test
    void test2() {
        int[][] ints = new int[3][4];
        ints = new int[][]{{1, 0, 0}, {2, 4, 6}, {9, 10, 7}};
        System.out.println(ints[0][0]);
        System.out.println(ints[1][2]);
        for (int[] i :
                ints) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void test3() {
//        Scanner scanner = new Scanner(System.in);
        String input = "-1 0 1 1 1 0 1 0 1 -1 1";
//        scanner.close();

        String[] tokens = input.split(" ");
        int[] chessColors = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            chessColors[i] = Integer.parseInt(tokens[i]);
        }

        // 现在你可以使用 chessColors 数组进行后续的处理
        for (int color : chessColors) {
            System.out.println(color);
        }
    }

    @Test
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> integers = new HashSet<Integer>();
        int length = nums.length;
        for (int j = 0; j < length; j++) {
            if (j > k) {
                integers.remove(nums[j - k - 1]);
            }
            if (!integers.add(nums[j])) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test4(){
        System.out.println(Math.abs(-1));
    }

}

import java.util.Scanner;

/**
 * ClassName: HJ65
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 * <p>
 * 数据范围：字符串长度1≤length≤300
 * 进阶：时间复杂度： O(n^3) ，空间复杂度：O(n)
 * 输入描述：
 * 输入两个字符串
 * <p>
 * 输出描述：
 * 返回重复出现的字符
 * 实例：
 * 输入：abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出：jklmnop
 *
 * @Author 18797
 * @Create 2023/8/10 17:47
 * @Version 1.0
 */
public class HJ65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String s = SubString(str1, str2);
        System.out.println(s);
    }

    public static String SubString(String a, String b) {
        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
            return "";
        }
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLength) {
                        maxLength = dp[i + 1][j + 1];
                        endIndex = i;
                    }
                }
            }
        }
        if (maxLength == 0) {
            return "";
        }

        return a.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}

//class Main {
//    public static void main(String[] args) {
//        String a = "abcdefg";
//        String b = "cdeft";
//
//        String result = findLongestCommonSubstring(a, b);
//        System.out.println("Longest Common Substring: " + result);
//    }
//
//    public static String findLongestCommonSubstring(String a, String b) {
//        if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
//            return "";
//        }
//
//        if (a.length() > b.length()) {
//            String temp = a;
//            a = b;
//            b = temp;
//        }
//
//        int[][] dp = new int[a.length() + 1][b.length() + 1];
//        int maxLength = 0;
//        int endIndex = 0;
//
//        for (int i = 1; i <= a.length(); i++) {
//            for (int j = 1; j <= b.length(); j++) {
//                if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    if (dp[i][j] > maxLength) {
//                        maxLength = dp[i][j];
//                        endIndex = i - 1;
//                    }
//                }
//            }
//        }
//
//        if (maxLength == 0) {
//            return "";
//        }
//
//        return a.substring(endIndex - maxLength + 1, endIndex + 1);
//    }
//}

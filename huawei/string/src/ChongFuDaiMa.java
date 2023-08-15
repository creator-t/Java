import java.util.Scanner;

/**
 * ClassName: ChongFuDaiMa
 * Package: PACKAGE_NAME
 * Description:
 * 题目描述:
 * 小明负责维护项目下的代码，需要查找出重复代码，用以支撑后续的代码优化，请你帮助小明找出重复的代码。重复代码查找方法:以字符串形式给定两行代码（字符串长度1<length <=100，由英文字母、数字和空格组成)，找出两行代码中的最长公共子串Q。注;如果不存在公共子串，返回空字符串
 * 输入描述:
 * 输入的参数text1, text2分别表示两行代码
 * 输出描述:
 * 输出任一最长公共子串
 * 示例1
 * 输入∶
 * 1 | hello123world hello123abc4
 * 输出:
 * 1| hello123
 *
 * @Author 18797
 * @Create 2023/8/15 21:27
 * @Version 1.0
 */
public class ChongFuDaiMa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        repeatStr(str1, str2);

    }

    private static void repeatStr(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            System.out.println(" ");
        }
        int m = str1.length();
        int n = str2.length();
        int[][] result = new int[m+1][n+1];
        result[0][0] = 0;
        int endIndex = 0;
        int maxLength = 0;

        //寻找最长公共子串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                    if (result[i][j] > maxLength) {
                        maxLength = result[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        String temp = str1.substring(endIndex - maxLength + 1, endIndex + 1);
        System.out.println(temp);
    }
}
//text1 = "private_void_method", text2 = "public_void_method",
//hello123world
//hello123abc4
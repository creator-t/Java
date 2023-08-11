import javax.xml.stream.events.Characters;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: HJ71
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 * <p>
 * 注意：匹配时不区分大小写。
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * <p>
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 数据范围：字符串长度：1≤s≤100
 * 进阶：时间复杂度：O(n^2) ，空间复杂度：O(n)
 * <p>
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * <p>
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 *
 * @Author 18797
 * @Create 2023/8/10 18:41
 * @Version 1.0
 */
public class HJ71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        str1 = str1.toLowerCase();
        String str2 = scanner.nextLine();
        str2 = str2.toLowerCase();
        System.out.println(isMatch(str1, str2));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //空字符串匹配空表达式总为true
        dp[0][0] = true;
        //空字符串匹配非空表达式，只有表达式全为*才为true
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        //非空字符串匹配空表达式总为false

        //非空字符串匹配非空表达式
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //当表达式为？时
                if (p.charAt(j - 1) == '?'
                        && ((s.charAt(i - 1) >= 'a' && s.charAt(i - 1) <= 'z')
                        || (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9'))
                        || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}

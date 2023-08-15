import java.util.Scanner;

/**
 * ClassName: 监控
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/12 19:26
 * @Version 1.0
 */
public class 监控 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] ints = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ints[i][j] == 1) {
                    result++;
                    continue;
                }
                if (j - 1 > 0 && ints[i][j - 1] == 1) {
                    result++;
                    continue;
                }
                if( j+1 <n && ints[i][j+1] == 1){
                    result++;
                    continue;
                }
                if (i -1 > 0 && ints[i-1][j] ==1){
                    result++;
                    continue;
                }
                if (i+1<m && ints[i+1][j]==1){
                    result++;
                    continue;
                }
            }
        }
        System.out.println(result);

    }
}

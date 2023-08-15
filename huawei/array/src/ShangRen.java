import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * ClassName: ShangRen
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/15 18:53
 * @Version 1.0
 */
public class ShangRen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int days = scanner.nextInt();
        int[] maxNumber = new int[number];
        for (int i = 0; i < number; i++) {
            maxNumber[i] = scanner.nextInt();
        }
        int[][] price = new int[number][days];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                price[i][j] = scanner.nextInt();
            }
        }
        int result = 0;
        for (int i = 0; i < number; i++) {

            for (int j = 1; j < days; j++) {
                if (price[i][j] > price[i][j - 1]) {
                    result += (price[i][j] - price[i][j - 1]) * maxNumber[i];
                }
            }
        }
        System.out.println(result);
    }
}
//8  24
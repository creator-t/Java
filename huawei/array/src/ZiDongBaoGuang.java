import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: ZiDongBaoGuang
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/15 19:47
 * @Version 1.0
 */
public class ZiDongBaoGuang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int sum = 0;
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sum = Arrays.stream(nums).sum();
        int number = nums.length;

        double i = ((128 * number) - sum) / number;
        solve_method(nums);
        System.out.println((int) i);


    }

    private static void solve_method(int[] nums) {
        int ans = 0;
        int t = Integer.MAX_VALUE;
        for (int i = -137; i < 255; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                int tmp = i + nums[j];
                if (tmp < 0 ){
                    tmp = 0;
                }else if (tmp > 255){
                    tmp = 255;
                }
                sum = sum + tmp;



            }
            int abs = Math.abs(128 * nums.length - sum);
            if (t> abs){
                ans = i;
                t = abs;
            }

        }
        System.out.println(ans);
    }
}

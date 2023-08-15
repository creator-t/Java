import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: HuangJin
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/13 19:58
 * @Version 1.0
 */
public class HuangJin {
    public static void main(String[] args) {
        //处理输入
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        //计算和
        for (int i = 0; i < ints.length ; i++) {
            int right = 0;
            int left = 0;
            for (int j = 0; j < i; j++) {
                left += ints[j];
            }
            for (int j = i+1; j < ints.length; j++) {
                right += ints[j];
            }
            if (right == left){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}

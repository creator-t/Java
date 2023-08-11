import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: HJ101
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * <p>
 * 数据范围： 1≤n≤1000  ，元素大小满足 100000
 * 0≤val≤100000
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 * <p>
 * 输出描述：
 * 输出排好序的数字
 *
 * @Author 18797
 * @Create 2023/8/11 23:43
 * @Version 1.0
 */
public class HJ101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(arr);
        int flag = scanner.nextInt();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
//
                if (flag == 0) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }
        for (int i :
                arr) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

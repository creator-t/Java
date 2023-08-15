import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: HJ80
 * Package: PACKAGE_NAME
 * Description:
 * 题目标题：
 *
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 *
 *
 *
 * 输入描述：
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 *
 * 输出描述：
 * 输出合并之后的数组
 * @Author 18797
 * @Create 2023/8/12 14:10
 * @Version 1.0
 */
public class HJ80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length1 = scanner.nextInt();
        int[] ints1 = new int[length1];
        for (int i = 0; i < length1; i++) {
            ints1[i] = scanner.nextInt();
        }
        int length2 = scanner.nextInt();
        int[] ints2 = new int[length2];
        for (int i = 0; i < length2; i++) {
            ints2[i] = scanner.nextInt();
        }
        Arrays.sort(ints1);
        Arrays.sort(ints2);
        int[] ints3 = new int[length1 + length2];
        Arrays.fill(ints3,ints1[length1-1]+10);
        int i = 0;
        int j = 0;
        int index = 0;
        while (i<length1 && j<length2){
            if (ints1[i]<ints2[j]){
                if(index != 0 && ints3[index-1] == ints1[i]){
                    i++;
                }else{

                    ints3[index++] = ints1[i++];
                }
            }else if (ints1[i]>ints2[j]){
                if(index != 0 && ints3[index-1] == ints2[j]){
                    j++;
                }else{

                    ints3[index++] = ints2[j++];
                }

            }else{
                if(index != 0 && ints3[index-1] == ints2[j]){
                    j++;
                }else{
                    ints3[index++] = ints2[j++];
                }
            }
        }
        while (i<length1){
            if(index != 0 && ints3[index-1] == ints1[i]){
                i++;
            }else{

                ints3[index++] = ints1[i++];
            }
        }
        while (j<length2){
            if(index != 0 && ints3[index-1] == ints2[j]){
                j++;
            }else{
                ints3[index++] = ints2[j++];
            }

        }
        for (int k = 0; k < index; k++) {
            System.out.print(ints3[k]);
        }

    }
}

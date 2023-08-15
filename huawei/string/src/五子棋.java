import java.util.Scanner;

/**
 * ClassName: 五子棋
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/12 23:29
 * @Version 1.0
 */
public class 五子棋 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chessColor = scanner.nextInt();
        System.out.println("chessColor" + chessColor);
        scanner.nextLine();
        System.out.println(chessColor);
        String str = scanner.nextLine();
        System.out.println(str);
        String str1 = str.replaceAll(" ", "").replaceAll("-1","2");

        char[] s = str1.toCharArray();
        if (!str1.contains("0")) {
            System.out.println(-1);
            return;
        }
        int[] ints = new int[s.length];
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                for (int j = i - 1; j >= 0 && s[j] == (chessColor == 1 ? '1' : '2'); j--) {
                    ints[i]++;
                }
                for (int j = i + 1; j < s.length && s[j] == (char) chessColor; j++) {
                    ints[i]++;
                }

            } else {
                continue;
            }

        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > ints[index]) {
                index = i;
            }
        }
        System.out.println(index);
    }
}

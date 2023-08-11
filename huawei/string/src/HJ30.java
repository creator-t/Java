import java.util.Scanner;

/**
 * ClassName: HJ30
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 按照指定规则对输入的字符串进行处理。
 * <p>
 * 详细描述：
 * <p>
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
 * <p>
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
 * <p>
 * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
 * 转换规则如下：
 * 对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
 * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
 * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
 * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
 * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
 * 1000
 * <p>
 * 数据范围：输入的字符串长度满足 1≤n≤100
 *
 * @Author 18797
 * @Create 2023/8/11 20:30
 * @Version 1.0
 */
public class HJ30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String s = str1 + str2;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            for (int j = 0; j < chars.length; j = j + 2) {
                if (chars[i] < chars[j]) {
                    swap(chars, i, j);
                }
            }
        }
        for (int i = 1; i < chars.length; i = i + 2) {
            for (int j = 1; j < chars.length; j = j + 2) {
                if (chars[i] < chars[j]) {
                    swap(chars, i, j);
                }
            }
        }
//        for (char ch :
//                chars) {
//            System.out.print(ch);
//        }
        String result = hexConversion(String.copyValueOf(chars));
        System.out.println(result);
    }

    public static void swap(char[] chars, int i, int j) {
        Character temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static String hexConversion(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isDigit(c) || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f')) {

                int decimal = Character.digit(c, 16);
                String binary = String.format("%4s", Integer.toBinaryString(decimal)).replace(' ', '0');
                String reversedBinary = new StringBuilder(binary).reverse().toString();
                int reversedDecimal = Integer.parseInt(reversedBinary, 2);
                char hexChar = Character.toUpperCase(Integer.toHexString(reversedDecimal).charAt(0));
                result.append(hexChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

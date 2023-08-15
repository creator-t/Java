import javax.crypto.Cipher;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * ClassName: XinCiWanJue
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/13 23:55
 * @Version 1.0
 */
public class XinCiWanJue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        String word = scanner.nextLine();
        scanner.close();
//        int result = 0;
//        for (int i = 0; i < content.length(); i++) {
//            if (i >= word.length() - 1) {
//                int index = 0;
//
//                for (int j = i; j >= 0 && index < word.length(); j--) {
//
//                    if (content.charAt(j) == word.charAt(index)) {
//
//                        if (index == word.length() - 1) {
//                            result++;
//                        }
//                        index++;
//                    }else {
//                        break;
//                    }
//                }
//
//            }
//            if (content.length() - i >= word.length()) {
//                int index = 0;
//                for (int j = i; j < content.length() && index < word.length(); j++) {
//
//                    if (content.charAt(j) == word.charAt(index)) {
//
//                        if (index == word.length() - 1) {
//                            result++;
//                        }
//                        index++;
//                    }else {
//                        break;
//                    }
//                }
//            }
//        }
//        System.out.println(result);
        System.out.println(content+word);
        huaDong(content,word);
    }
    public static void huaDong(String content,String word){
        int m = content.length();
        int n = word.length();
        int left = 0;
        int right = word.length()-1;
        String reverse = new StringBuilder(word).reverse().toString();
        int result = 0;
        for (; right < m; right++,left++) {
            if (reverse.equals(content.substring(left,right+1)) || word.equals(content.substring(left,right+1))){
                result++;
            }
        }

        System.out.println(result);
    }
}

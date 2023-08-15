import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: CaiZiMi
 * Package: PACKAGE_NAME
 * Description:
 * 本体题目：猜字谜
 * 题目描述:
 * 小王设计了一个简单的猜字谜游戏，游戏的谜面是一个错误的单词，比如nesw，玩家需要猜出谜底库中正确的单词。猜中的要求如吓下:
 * 对于某个谜面和谜底单词，满足下面任—条件都表示猜中:
 * 1）变换顺序以后一样的，比如通过变换w和e的顺序,“nwes"跟"news"是可以完全对应的;
 * 2)字母去重以后是一样的，比如'wood"和'wood"是一样的，它们去重后都是"wod"请你写一个程序帮忙在谜底库中找到正确的谜底。谜面是多个单词，都需要找到对应的谜底，如果找不到的话，返回"not found"
 * 输入描述:
 * 1、谜面单词列表，以", "分隔
 * 2、谜底库单词列表，以", "分隔
 * 输出描述:
 * 匹配到的正确单词列表，以“,”分隔如果找不到，返回"not found"
 * @Author 18797
 * @Create 2023/8/15 22:33
 * @Version 1.0
 */
public class CaiZiMi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str1 = Arrays.stream(scanner.nextLine().split(",")).toList().toArray(new String[0]);
        String[] str2 = Arrays.stream(scanner.nextLine().split(",")).toList().toArray(new String[0]);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                //排序字符串str
                String str3 = str1[i];
                StringBuilder builder1 = new StringBuilder();
                for (int k = 0; k < str3.length(); k++) {

                    if (k != 0 && str3.charAt(k - 1) == str3.charAt(k)) {

                    } else {
                        builder1.append(str3.charAt(k));
                    }

                }
                char[] chars = builder1.toString().toCharArray();
                Arrays.sort(chars);

                String str4 = str2[j];
                StringBuilder builder2 = new StringBuilder();
                for (int k = 0; k < str4.length(); k++) {

                    if (k != 0 && str4.charAt(k - 1) == str4.charAt(k)) {

                    } else {
                        builder2.append(str4.charAt(k));
                    }

                }


                char[] chars1 = builder2.toString().toCharArray();
                Arrays.sort(chars1);

                if (Arrays.toString(chars).equals(Arrays.toString(chars1))) {
                    map.put(i, j);
                }
            }

        }
        if (map.isEmpty()) {
            System.out.println("not found");
            return;
        }
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            builder.append(str2[entry.getValue()]).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder);


    }
}

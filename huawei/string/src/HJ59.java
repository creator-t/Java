import java.util.*;

/**
 * ClassName: HJ59
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 找出字符串中第一个只出现一次的字符
 * <p>
 * 数据范围：输入的字符串长度满足 1≤n≤1000
 * <p>
 * 输入描述：
 * 输入一个非空字符串
 * <p>
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 * <p>
 * 示例1
 * 输入：
 * asdfasdfo
 *
 * @Author 18797
 * @Create 2023/8/9 22:53
 * @Version 1.0
 */
public class HJ59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (Character ch :
                str.toCharArray()) {
            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        boolean b = map.containsValue(1);
        if (!b) {
            System.out.println(-1);
            return;
        }
        System.out.println(getKeyByValue(map, 1));

    }

    private static Character getKeyByValue(HashMap<Character, Integer> map, Integer value) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return (entry.getKey());
            }
        }

        return null;
    }
}

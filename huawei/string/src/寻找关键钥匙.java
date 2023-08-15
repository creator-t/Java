import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName: 寻找关键钥匙
 * Package: PACKAGE_NAME
 * Description:
 * 本篇题目:寻找关键钥匙
 * 题目
 * 小强正在参加《密室逃生》游戏，当前关卡要求找到符合给定密码K(升序的不重复小写字母组成)的箱子，并给出箱子编号，箱子编号为1~N。
 * 每个箱子中都有一个字符串s，字符串由大写字母，小写字母，数字，标点符号，空格组成，需要在这些字符串中找出所有的字母，忽略大小写后排列出对应的密码串，并返回匹配密码的箱子序号。
 * 提示:满足条件的箱子不超过1个
 * 输入描述
 * 第一行为key 的字符串，第二行为箱子boxes，为数组样式，以空格分隔
 * 箱子N数量满足1<=N<=1000,s长度满足(<=s.length<=50,密码为仅包含小写字母的升序字符串，且不存在重复字母,密码K长度K.length,1<=K.length<=26
 * 输出描述:
 * 返回对应箱子编号，如不存在符合要求的密码箱，则返回-1
 * 补充说明
 * 箱子中字符拼出的字符串与密码的匹配忽略大小写，且要求与密码完全匹配，如密码abc 匹配 aBc，但是密码abc不匹配 abcd
 * 示例一
 * 输入
 * abc
 * s , sdf134 A2c4b
 * 输出
 * 2
 * 说明
 * 第2个箱子中的Abc，符合密码abc
 * 示例二
 * 输入
 * abc
 * s , sdf134 A2c4bd 523[]
 * 输出
 * -1
 *
 * @Author 18797
 * @Create 2023/8/15 23:24
 * @Version 1.0
 */
public class 寻找关键钥匙 {
    public static void main(String[] args) {
        Arrays.sort(new Integer[]{0,2,5,1,3}, Comparator.reverseOrder());
    }
}

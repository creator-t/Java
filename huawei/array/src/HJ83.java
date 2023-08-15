import java.util.Scanner;

/**
 * ClassName: HJ83
 * Package: PACKAGE_NAME
 * Description:
 * 描述
 * 有一个m∗n 大小的数据表，你会依次进行以下5种操作：
 * 1.输入m 和n ，初始化m∗n 大小的表格。
 * 2.输入1x1
 * ​
 * 、
 * �
 * 1
 * y
 * 1
 * ​
 * 、
 * �
 * 2
 * x
 * 2
 * ​
 * 、
 * �
 * 2
 * y
 * 2
 * ​
 * ，交换坐标在
 * (
 * �
 * 1
 * ,
 * �
 * 1
 * )
 * (x
 * 1
 * ​
 * ,y
 * 1
 * ​
 * )和
 * (
 * �
 * 2
 * ,
 * �
 * 2
 * )
 * (x
 * 2
 * ​
 * ,y
 * 2
 * ​
 * )的两个数。
 * 3.输入x ，在第x 行上方添加一行。
 * 4.输入y ，在第y 列左边添加一列。
 * 5.输入y ，查找坐标为(x,y) 的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 * <p>
 * 详细要求:
 * <p>
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的m∗n 大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对m∗n 大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 * <p>
 * 本题含有多组样例输入！行列从0开始标号
 * 数据范围：数据组数：1≤t≤5
 * 进阶：时间复杂度：O(1) ，空间复杂度：O(1)
 * 输入描述：
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 * <p>
 * 输出描述：
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 *
 * @Author 18797
 * @Create 2023/8/12 16:36
 * @Version 1.0
 */
public class HJ83 {
    public static void main(String[] args) {
//TODO 没有做完
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            int[][] ints = new int[m][n];
            System.out.println(0);
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int sp = swap(ints, x1, y1, x2, y2);
            System.out.println(sp);
            int x = scanner.nextInt();
            int addR = addRow(ints, x);
            System.out.println(addR);
            int y = scanner.nextInt();
            int addC = addColum(ints, y);
            System.out.println(addC);
            int x3 = scanner.nextInt();
            int y3 = scanner.nextInt();
            int fd = find(ints, x3, y3);
            System.out.println(fd);
        }


    }

    private static int find(int[][] ints, int x3, int y3) {
        if (x3 - 1 >= ints.length || y3 - 1 >= ints[0].length) {
            return -1;
        }
        int a = ints[x3 - 1][y3 - 1];
        return 0;
    }

    private static int addColum(int[][] ints, int y) {
        if (y - 1 >= ints.length) {
            return -1;
        }
        int[][] copy = new int[ints.length + 1][ints[0].length];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (i < y) {
                    copy[i][j] = ints[i][j];
                } else if (i >= y) {
                    copy[i + 1][j] = ints[i][j];
                }
            }
        }
        ints = copy;
        return 0;
    }

    private static int addRow(int[][] ints, int x) {
        if (x - 1 >= ints[0].length) {
            return -1;
        }
        int[][] copy = new int[ints.length][ints[0].length + 1];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                if (j < x) {
                    copy[i][j] = ints[i][j];
                } else if (j >= x) {
                    copy[i][j + 1] = ints[i][j];
                }
            }
        }
        ints = copy;
        return 0;
    }

    private static int swap(int[][] ints, int x1, int y1, int x2, int y2) {
        if (x1 - 1 >= ints.length || x2 - 1 >= ints.length || y1 - 1 >= ints[0].length || y2 - 1 >= ints[0].length) {
            return -1;
        }
        int temp = ints[x1 - 1][y1 - 1];
        ints[x1 - 1][y1] = ints[x2 - 1][y2 - 1];
        ints[x2 - 1][y2 - 1] = temp;
        return 0;
    }
}

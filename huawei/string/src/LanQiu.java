import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: LanQiu
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/14 10:46
 * @Version 1.0
 */


public class LanQiu {
    static boolean check(List<Integer> list, int number, int beforeNumber) {
        if (number == beforeNumber && list.size()==0){
            return true;
        }
        boolean status = false;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (i!=j){
                    subList.add(list.get(i));
                }
                if(list.get(i)==number){
                    status = status || check(subList,beforeNumber,beforeNumber);
                }else if(list.get(i) < number){
                    status = status || check(subList,number-list.get(i),beforeNumber);
                }
            }
        }
        return status;
    }

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int t = scan.nextInt();
            if (t < 1 || t > 50) {
                System.out.println("input error");
                return;
            }
            int[] scoreArray = new int[t];
            for (int i = 0; i < scoreArray.length; ++i) {
                scoreArray[i] = scan.nextInt();
            }
            int result = 0;
            List<Integer> list = new ArrayList<>();
            for (int p : scoreArray) {
                result += p;
                list.add(p);
            }
            for (int j = scoreArray.length; j > 0; j--) {
                int finalResult = result;
                int finalJ = j;
                if (result % j == 0 && list.stream().filter(i -> i > (finalResult / finalJ)).toList().size()==0 && check(list, result / j, result / j)) {
                    System.out.println(result / j);
                    return;
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("input error");
        }
    }
}


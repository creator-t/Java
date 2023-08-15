import java.util.*;

/**
 * ClassName: DianTi
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/13 22:11
 * @Version 1.0
 */
public class DianTi {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int targetFloor = scanner.nextInt();
//        int length = scanner.nextInt();
//
//        List<Integer> sequence = new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            sequence.add(scanner.nextInt());
//        }
//        scanner.close();
//        List<Integer> list = getElevatorSequence(targetFloor, sequence);
//        for (int i :
//                list) {
//            System.out.println(i);
//        }
//    }
//
//    private static List<Integer> getElevatorSequence(int targetFloor, List<Integer> sequence) {
//        List<Integer> uniqueSequence = new ArrayList<>(new HashSet<>(sequence));
//        uniqueSequence.sort(Collections.reverseOrder());
//        int currentFloor = 0;
//        int direction = 1;
//        List<Integer> result = new ArrayList<>();
//        for (int num :
//                uniqueSequence) {
//            if (currentFloor + num <= targetFloor) {
//                currentFloor += num;
//            } else {
//                currentFloor -= num;
//            }
//            result.add(num);
//            direction *= -1;
//
//        }
//        return result;
//    }

    public static List<Integer> getElevatorSequence(int targetFloor, List<Integer> sequence) {
        List<Integer> uniqueSequence = new ArrayList<>(new HashSet<>(sequence));
        Collections.sort(uniqueSequence, Collections.reverseOrder());

        int currentFloor = 0;
        int direction = 1;
        List<Integer> result = new ArrayList<>();

        for (int num : uniqueSequence) {
            if (currentFloor + num <= targetFloor) {
                currentFloor += num;
            } else {
                currentFloor -= num;
            }
            result.add(num);
            direction *= -1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetFloor = scanner.nextInt();
        int sequenceSize = scanner.nextInt();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < sequenceSize; i++) {
            sequence.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> result = getElevatorSequence(targetFloor, sequence);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


}

import java.util.*;

/**
 * ClassName: 选修课
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/13 17:44
 * @Version 1.0
 */
public class XuanXiuKe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] split1 = s1.split(";");
        String s2 = scanner.nextLine();
        String[] split2 = s2.split(";");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (String s :
                split1) {
            String[] arr = s.split(",");
            for (int i = 0; i < arr.length; i++) {
                hashMap.put(arr[i], Integer.valueOf(arr[++i]));
            }


        }
        Comparator<Student> stuComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (!Objects.equals(s1.getTotalScore(), s2.getTotalScore())) {
                    return Integer.compare(s1.getTotalScore(), s2.getTotalScore());
                }
                return s1.getsId().compareTo(s2.getsId());
            }
        };
        TreeMap<String, TreeSet<Student>> treeMap = new TreeMap<>();
        for (String s :
                split2) {
            String[] arr = s.split(",");
            String sId = arr[0];
            if (hashMap.containsKey(sId)){
                int fScore = hashMap.get(sId);
                int sScore = Integer.parseInt(arr[1]);
                int totalS = fScore + sScore;
                String cM = sId.substring(0,5);
                Student student = new Student(sId, totalS);
                TreeSet<Student> studentTreeSet = treeMap.computeIfAbsent(cM, k -> new TreeSet<>(stuComparator));
                studentTreeSet.add(student);

            }


        }
        if (treeMap.isEmpty()){
            System.out.println("null");
        }else {
            for (Map.Entry<String, TreeSet<Student>> entry:
                    treeMap.entrySet()){
                String Key = entry.getKey();
                TreeSet<Student> value = entry.getValue();
                StringBuilder builder = new StringBuilder(Key);
                builder.append("\n");
                for (Student stu :
                        value) {
                    builder.append(stu.getsId()).append(";");


                }
                builder.deleteCharAt(builder.length()-1);
                System.out.println(builder);

            }
        }
    }

    static class Student{
        String sId;
        Integer totalScore;

        public Student(String sId, Integer totalScore) {
            this.sId = sId;
            this.totalScore = totalScore;
        }

        public String getsId() {
            return sId;
        }

        public void setsId(String sId) {
            this.sId = sId;
        }

        public Integer getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(Integer totalScore) {
            this.totalScore = totalScore;
        }
    }
}

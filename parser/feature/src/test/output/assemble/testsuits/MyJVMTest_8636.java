public class MyJVMTest_8636 {

    static int[] o1 = { 1112740183, 0, 6, 1, -1264575409, -1138670405, 8, 5, 9, 0 };

    static int[] o2 = { 0, 0, 2, 0, 2028769315, -397668032, -598575445, -489752156, 3, 4 };

    static String content = "Ci0R;f'm B";

    int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8636().compare(o1, o2));
    }
}

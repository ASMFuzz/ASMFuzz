public class MyJVMTest_7654 {

    static int[] o1 = { 0, 0, 3, 0, 4, 0, 0, 707074631, -917132344, 0 };

    static int[] o2 = { 0, 5, 8, 1406552001, 0, -1402771551, -1522900595, 4, 545690665, 5 };

    static String content = "L0lrWQWwdZ";

    int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7654().compare(o1, o2));
    }
}

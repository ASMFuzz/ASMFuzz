public class MyJVMTest_17203 {

    static int[] o1 = { 0, 0, 0, -1723337321, 6, 1, 3, 0, 0, 0 };

    static int[] o2 = { 0, 7, 1684920589, 1, -879233478, 9, 0, 6, -1739281485, 0 };

    static String content = "T:\"^ jbg#Y";

    int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17203().compare(o1, o2));
    }
}

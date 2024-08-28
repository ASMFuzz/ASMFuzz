public class MyJVMTest_10102 {

    static int j = 2;

    static int k = 6;

    static int l = -307081181;

    static int m = 8;

    int helper(int j, int k, int l, int m) {
        return j + k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10102().helper(j, k, l, m));
    }
}

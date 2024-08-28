public class MyJVMTest_7001 {

    static int SIZE = 30;

    int fopt() {
        int[] a = new int[SIZE];
        int j = 1;
        if (j != 0)
            a[0] = 0;
        if (j != 0)
            a[1] = a[0] + 1;
        return a[1];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7001().fopt());
    }
}

public class MyJVMTest_2314 {

    static int SIZE = 30;

    int fopt() {
        int[] a = new int[SIZE];
        a[12] = 12;
        return a[12] = 12;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2314().fopt());
    }
}

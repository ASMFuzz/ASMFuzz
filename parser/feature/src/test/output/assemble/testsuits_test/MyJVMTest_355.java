public class MyJVMTest_355 {

    static int[] a = { 1362637231, 0, 8, 5, 4, 0, -1195362739, 0, 5, 0 };

    static int[] b = { 0, 3, 0, 2, 0, 7, 3, 4, 499828265, 0 };

    static int total = 1;

    int prodReductionImplement(int[] a, int[] b, int total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] + b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_355().prodReductionImplement(a, b, total));
    }
}

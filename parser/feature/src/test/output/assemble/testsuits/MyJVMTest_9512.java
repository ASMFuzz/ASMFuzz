public class MyJVMTest_9512 {

    static int[] a = { 2, 9, 4, -893373875, 3, 2, 1270144677, 6, 0, 0 };

    static int[] b = { -381978366, 0, 0, 0, 1393068811, 0, -1098934555, 1, 0, 0 };

    static int total = 1;

    int prodReductionImplement(int[] a, int[] b, int total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] + b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9512().prodReductionImplement(a, b, total));
    }
}

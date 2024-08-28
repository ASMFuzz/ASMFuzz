public class MyJVMTest_138 {

    static int[] a = { 2, 1303775731, -292378880, 0, 4, 3, 1848206525, 0, 8, 3 };

    long sum(int[] a) {
        long sum = 0;
        for (int index = 0; index < a.length; index++) {
            sum += a[index];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_138().sum(a));
    }
}

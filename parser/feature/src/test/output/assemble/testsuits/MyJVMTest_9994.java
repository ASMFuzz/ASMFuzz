public class MyJVMTest_9994 {

    static int[] a = { 0, 0, 0, 5, -195741537, 1, 7, 181369618, 0, 1 };

    int sumb2(int[] a) {
        Integer result1 = 1;
        Integer result2 = 1;
        for (Integer i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9994().sumb2(a));
    }
}

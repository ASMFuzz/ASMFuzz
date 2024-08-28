public class MyJVMTest_9855 {

    static int i = 1428736252;

    static int limit6 = Integer.MAX_VALUE - 10000;

    int test6(int i) {
        int result = 0;
        while (i-- != limit6) {
            result = i * 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9855().test6(i));
    }
}

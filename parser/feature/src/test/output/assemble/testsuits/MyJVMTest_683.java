public class MyJVMTest_683 {

    static int i = 0;

    static int limit6 = Integer.MAX_VALUE - 10000;

    int test6(int i) {
        int result = 0;
        while (i-- != limit6) {
            result = i * 2;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_683().test6(i));
    }
}

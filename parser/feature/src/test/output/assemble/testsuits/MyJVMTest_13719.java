public class MyJVMTest_13719 {

    static long a = -7677754053022265567L;

    static long b = 0;

    long test_sub(long a, long b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13719().test_sub(a, b));
    }
}

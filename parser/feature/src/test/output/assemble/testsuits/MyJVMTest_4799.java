public class MyJVMTest_4799 {

    static long a = -3207631763157293430L;

    static long b = 0;

    long checkMethod(long a, long b) {
        return Math.subtractExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4799().checkMethod(a, b));
    }
}

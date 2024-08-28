public class MyJVMTest_17196 {

    static long a = 4457615846211195336L;

    static long b = 1685193157901470497L;

    long checkMethod(long a, long b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17196().checkMethod(a, b));
    }
}

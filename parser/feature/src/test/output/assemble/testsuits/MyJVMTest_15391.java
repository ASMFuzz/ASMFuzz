public class MyJVMTest_15391 {

    static long startTime = -9223372036854775808L;

    static long endTime = 0;

    long getTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15391().getTime());
    }
}

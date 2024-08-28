public class MyJVMTest_17367 {

    static long TIMEOUT = 300000;

    static long startTime = System.currentTimeMillis();

    boolean timeout() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime > TIMEOUT;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17367().timeout());
    }
}

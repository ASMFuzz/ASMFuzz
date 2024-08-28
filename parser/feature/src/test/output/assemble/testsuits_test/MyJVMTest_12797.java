public class MyJVMTest_12797 {

    static Runnable threadParam1 = () -> {
    };

    static String threadParam2 = "9,G:Tu!,<:";

    static Thread thread = new Thread(threadParam1, threadParam2);

    static Throwable throwable = new Throwable();

    Throwable uncaughtException(Thread thread, Throwable throwable) {
        throwable.printStackTrace();
        System.exit(1);
        return throwable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12797().uncaughtException(thread, throwable);
    }
}

public class MyJVMTest_3466 {

    static Thread thread = new Thread();

    static String throwableParam1Param1 = "|V@>@~|+(o";

    static String throwableParam1Param2Param1 = "#Sr6>:*(v6";

    static String throwableParam1Param2Param2Param1 = "<mC@3]yI(9";

    static Throwable throwableParam1Param2Param2Param2 = new Throwable();

    static Throwable throwableParam1Param2Param2 = new Throwable(throwableParam1Param2Param2Param1, throwableParam1Param2Param2Param2);

    static Throwable throwableParam1Param2 = new Throwable(throwableParam1Param2Param1, throwableParam1Param2Param2);

    static Throwable throwableParam1 = new Throwable(throwableParam1Param1, throwableParam1Param2);

    static Throwable throwable = new Throwable(throwableParam1);

    Throwable uncaughtException(Thread thread, Throwable throwable) {
        throwable.printStackTrace();
        System.exit(1);
        return throwable;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3466().uncaughtException(thread, throwable);
    }
}

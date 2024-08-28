public class MyJVMTest_1452 {

    static String tParam1Param1Param1Param1Param1 = "3bOfb*b\\@*";

    static ThreadGroup tParam1Param1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1Param1);

    static String tParam1Param1Param1Param2 = "H)GCbhI-8l";

    static ThreadGroup tParam1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1, tParam1Param1Param1Param2);

    static String tParam1Param1Param2 = "/_eM>$DjHl";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1, tParam1Param1Param2);

    static String tParam1Param2 = "M\"?&T-<}wH";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static String tParam2 = "'Wawp.^`M_";

    static Thread t = new Thread(tParam1, tParam2);

    static String eParam1 = "+4;hzIf\"/L";

    static Throwable eParam2 = new Throwable();

    static Throwable e = new Throwable(eParam1, eParam2);

    Throwable uncaughtException(final Thread t, final Throwable e) {
        throw new RuntimeException(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1452().uncaughtException(t, e);
    }
}

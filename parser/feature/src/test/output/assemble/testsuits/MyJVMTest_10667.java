public class MyJVMTest_10667 {

    static String tParam1Param1Param1Param1 = "p(m$:MM#V!";

    static ThreadGroup tParam1Param1Param1 = new ThreadGroup(tParam1Param1Param1Param1);

    static String tParam1Param1Param2 = "yw[U0g#GxH";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1, tParam1Param1Param2);

    static String tParam1Param2 = "\"3;Pbd1-e1";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static Runnable tParam2 = () -> {
    };

    static String tParam3 = "v7FZc-.xNU";

    static Thread t = new Thread(tParam1, tParam2, tParam3);

    static String eParam1 = "@;g|Xa&}>1";

    static String eParam2Param1Param1 = "`=z=qbPV$\"";

    static String eParam2Param1Param2Param1 = "[Z,#=GST!{";

    static Throwable eParam2Param1Param2Param2 = new Throwable();

    static Throwable eParam2Param1Param2 = new Throwable(eParam2Param1Param2Param1, eParam2Param1Param2Param2);

    static Throwable eParam2Param1 = new Throwable(eParam2Param1Param1, eParam2Param1Param2);

    static Throwable eParam2 = new Throwable(eParam2Param1);

    static Throwable e = new Throwable(eParam1, eParam2);

    Throwable uncaughtException(final Thread t, final Throwable e) {
        throw new RuntimeException(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10667().uncaughtException(t, e);
    }
}

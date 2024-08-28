public class MyJVMTest_11711 {

    static String tParam1Param1 = "G&aAsH'@8n";

    static Throwable tParam1Param2 = new Throwable();

    static Throwable tParam1 = new Throwable(tParam1Param1, tParam1Param2);

    static Throwable t = new Throwable(tParam1);

    static int errors = 2;

    Throwable error(Throwable t) {
        t.printStackTrace();
        errors++;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11711().error(t);
    }
}

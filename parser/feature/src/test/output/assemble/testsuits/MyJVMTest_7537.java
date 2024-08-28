public class MyJVMTest_7537 {

    static String tParam1 = "6SqkpJL`(c";

    static String tParam2Param1 = "7v!i'|&~>C";

    static String tParam2Param2Param1 = "@0sTM+\\=H~";

    static Throwable tParam2Param2 = new Throwable(tParam2Param2Param1);

    static boolean tParam2Param3 = true;

    static boolean tParam2Param4 = false;

    static Throwable tParam2 = new Throwable(tParam2Param1, tParam2Param2, tParam2Param3, tParam2Param4);

    static boolean tParam3 = true;

    static boolean tParam4 = false;

    static Throwable t = new Throwable(tParam1, tParam2, tParam3, tParam4);

    boolean isNonFatal(Throwable t) {
        if (t instanceof StackOverflowError) {
            return true;
        } else if (t instanceof VirtualMachineError || t instanceof ThreadDeath || t instanceof InterruptedException || t instanceof LinkageError) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7537().isNonFatal(t));
    }
}

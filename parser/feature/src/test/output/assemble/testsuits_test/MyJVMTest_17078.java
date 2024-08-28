public class MyJVMTest_17078 {

    static String tParam1 = "hcQ8:k39Z3";

    static Throwable tParam2 = new Throwable();

    static Throwable t = new Throwable(tParam1, tParam2);

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
        System.out.println(new MyJVMTest_17078().isNonFatal(t));
    }
}

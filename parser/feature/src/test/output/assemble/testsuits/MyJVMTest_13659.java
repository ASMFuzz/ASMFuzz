public class MyJVMTest_13659 {

    static String exceptionParam1Param1 = "U!y[#SuyvF";

    static Throwable exceptionParam1 = new Throwable(exceptionParam1Param1);

    static Exception exception = new Exception(exceptionParam1);

    static String[] array = {"V!@Mbx:'ID","w2N\":M}|7v","rb6$'+#58v","8\\yi|vcn@A","?wa0+qy>AK","Y;~I,F_.g>","L^`a^7}5pj","ici&*P0-ZG","QUdpHke.x|","t,X _\"tDn:"};

    Exception exceptionThrown(Exception exception) {
        throw new Error("unexpected error", exception);
        return exception;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13659().exceptionThrown(exception);
    }
}

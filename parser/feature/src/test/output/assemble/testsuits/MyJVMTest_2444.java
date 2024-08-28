public class MyJVMTest_2444 {

    static String tParam1 = "VQ,_}*H~nG";

    static String tParam2Param1 = "G,<B_|D$Ts";

    static String tParam2Param2Param1 = "P~,Jmg%^}Y";

    static Throwable tParam2Param2 = new Throwable(tParam2Param2Param1);

    static Throwable tParam2 = new Throwable(tParam2Param1, tParam2Param2);

    static Throwable t = new Throwable(tParam1, tParam2);

    static int errors = -333852840;

    Throwable error(Throwable t) {
        t.printStackTrace();
        errors++;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2444().error(t);
    }
}

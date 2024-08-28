public class MyJVMTest_80 {

    static String mech = "d*F2q*1q=[";

    boolean isDRBG(String mech) {
        return mech.contains("_DRBG");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_80().isDRBG(mech));
    }
}

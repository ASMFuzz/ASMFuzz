public class MyJVMTest_9223 {

    static String mech = "CTX[pN[r1x";

    boolean isDRBG(String mech) {
        return mech.contains("_DRBG");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9223().isDRBG(mech));
    }
}

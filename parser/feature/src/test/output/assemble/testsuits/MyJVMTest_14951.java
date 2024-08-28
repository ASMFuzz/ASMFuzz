public class MyJVMTest_14951 {

    static long along = 0;

    static boolean mutable = true;

    long getALong() {
        return mutable ? along++ : along;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14951().getALong());
    }
}

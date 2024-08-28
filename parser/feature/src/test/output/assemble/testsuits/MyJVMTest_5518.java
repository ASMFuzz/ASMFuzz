public class MyJVMTest_5518 {

    static long along = 0;

    static boolean mutable = true;

    long getALong() {
        return mutable ? along++ : along;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5518().getALong());
    }
}

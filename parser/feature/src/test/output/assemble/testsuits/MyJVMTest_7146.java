public class MyJVMTest_7146 {

    <E1 extends Throwable> Integer computeThrowable() throws E1 {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7146().computeThrowable());
    }
}

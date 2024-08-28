public class MyJVMTest_16669 {

    <E1 extends Throwable> Integer computeThrowable() throws E1 {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16669().computeThrowable());
    }
}

public class MyJVMTest_13700 {

    Boolean get() {
        return new Boolean(true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13700().get());
    }
}

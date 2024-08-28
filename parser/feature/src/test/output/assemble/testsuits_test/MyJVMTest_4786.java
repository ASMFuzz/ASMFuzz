public class MyJVMTest_4786 {

    Object get() {
        return new Object();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4786().get());
    }
}

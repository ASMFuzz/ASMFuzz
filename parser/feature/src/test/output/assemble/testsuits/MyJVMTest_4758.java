public class MyJVMTest_4758 {

    Integer meth() {
        return Integer.valueOf(99);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4758().meth());
    }
}

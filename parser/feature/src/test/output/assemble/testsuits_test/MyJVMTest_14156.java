public class MyJVMTest_14156 {

    Integer meth() {
        return Integer.valueOf(99);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14156().meth());
    }
}

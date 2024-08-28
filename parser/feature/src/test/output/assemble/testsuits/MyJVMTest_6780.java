public class MyJVMTest_6780 {

    String helpException() {
        return "Test only single exception event gets thrown with JNI frame before handler";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6780().helpException());
    }
}

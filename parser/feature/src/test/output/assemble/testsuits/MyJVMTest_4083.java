public class MyJVMTest_4083 {

    int val() {
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4083().val());
    }
}

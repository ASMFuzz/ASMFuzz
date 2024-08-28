public class MyJVMTest_7782 {

    int f() {
        if (!false) {
            RuntimeException ex = new RuntimeException();
            System.out.println("before throw");
            throw ex;
        }
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7782().f());
    }
}

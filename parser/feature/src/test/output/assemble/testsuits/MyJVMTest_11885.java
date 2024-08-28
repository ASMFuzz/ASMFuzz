public class MyJVMTest_11885 {

    int superMethod() {
        return 200;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11885().superMethod());
    }
}

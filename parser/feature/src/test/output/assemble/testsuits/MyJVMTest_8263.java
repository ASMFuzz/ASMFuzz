public class MyJVMTest_8263 {

    int superMethod() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8263().superMethod());
    }
}

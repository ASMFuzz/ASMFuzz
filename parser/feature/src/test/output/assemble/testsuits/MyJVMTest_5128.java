public class MyJVMTest_5128 {

    Object someMethod() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5128().someMethod());
    }
}

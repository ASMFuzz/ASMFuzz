public class MyJVMTest_14543 {

    Object someMethod() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14543().someMethod());
    }
}

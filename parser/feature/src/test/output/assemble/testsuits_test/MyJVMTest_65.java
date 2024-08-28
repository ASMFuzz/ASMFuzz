public class MyJVMTest_65 {

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    String getCheckedException() throws Exception {
        throw theCheckedException;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_65().getCheckedException());
    }
}

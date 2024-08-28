public class MyJVMTest_9207 {

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    String getCheckedException() throws Exception {
        throw theCheckedException;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9207().getCheckedException());
    }
}

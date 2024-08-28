public class MyJVMTest_10341 {

    void thrower() throws NumberFormatException {
        throw new NumberFormatException("redefined");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10341().thrower();
    }
}

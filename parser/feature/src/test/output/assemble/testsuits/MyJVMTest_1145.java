public class MyJVMTest_1145 {

    void thrower() throws NumberFormatException {
        throw new NumberFormatException("redefined");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1145().thrower();
    }
}

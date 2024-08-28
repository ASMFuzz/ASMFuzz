public class MyJVMTest_6462 {

    static Object o = 9;

    Object Unreached(Object o) throws Exception {
        throw new Exception("Expected exception was not thrown");
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6462().Unreached(o);
    }
}

public class MyJVMTest_15950 {

    static Object o = 5;

    Object Unreached(Object o) throws Exception {
        throw new Exception("Expected exception was not thrown");
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15950().Unreached(o);
    }
}

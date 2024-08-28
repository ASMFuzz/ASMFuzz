public class MyJVMTest_13024 {

    static Object attrName = 4;

    boolean isDefined(Object attrName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13024().isDefined(attrName));
    }
}

public class MyJVMTest_3687 {

    static Object attrName = 0;

    boolean isDefined(Object attrName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3687().isDefined(attrName));
    }
}

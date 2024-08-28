public class MyJVMTest_5397 {

    static Object object = 3;

    Object unbalancedMonexit(Object object) {
        return;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5397().unbalancedMonexit(object);
    }
}

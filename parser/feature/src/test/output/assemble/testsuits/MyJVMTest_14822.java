public class MyJVMTest_14822 {

    static Object object = 0;

    Object unbalancedMonexit(Object object) {
        return;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14822().unbalancedMonexit(object);
    }
}

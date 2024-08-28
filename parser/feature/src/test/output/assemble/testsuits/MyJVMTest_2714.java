public class MyJVMTest_2714 {

    static Object object = 0;

    Object unbalancedMonenter(Object object) {
        return;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2714().unbalancedMonenter(object);
    }
}

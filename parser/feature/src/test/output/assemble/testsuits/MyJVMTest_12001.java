public class MyJVMTest_12001 {

    static Object object = 1722204403;

    Object unbalancedMonenter(Object object) {
        return;
        return object;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12001().unbalancedMonenter(object);
    }
}

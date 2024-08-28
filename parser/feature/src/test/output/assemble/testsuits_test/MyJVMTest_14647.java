public class MyJVMTest_14647 {

    static Object bean = 5;

    Object setObject(Object bean) {
        throw new UnsupportedOperationException();
        return bean;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14647().setObject(bean);
    }
}

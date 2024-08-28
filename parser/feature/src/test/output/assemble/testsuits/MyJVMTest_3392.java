public class MyJVMTest_3392 {

    Class<?> getListenerType() {
        return TestListener.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3392().getListenerType());
    }
}

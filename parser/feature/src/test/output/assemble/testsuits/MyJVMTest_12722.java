public class MyJVMTest_12722 {

    Class<?> getListenerType() {
        return TestListener.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12722().getListenerType());
    }
}

public class MyJVMTest_2255 {

    Class<?> getLocalClass() {
        class InnerLocal {

            public InnerLocal() {
            }
        }
        return InnerLocal.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2255().getLocalClass());
    }
}

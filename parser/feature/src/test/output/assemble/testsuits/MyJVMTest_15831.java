public class MyJVMTest_15831 {

    Class<?> getLocalClass() {
        class NestedInnerLocal {

            public NestedInnerLocal() {
            }
        }
        return NestedInnerLocal.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15831().getLocalClass());
    }
}

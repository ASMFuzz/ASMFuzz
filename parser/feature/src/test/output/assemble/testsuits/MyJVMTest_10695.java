public class MyJVMTest_10695 {

    NonJavaNames.myInterface create() {
        class Baz2 implements NonJavaNames.myInterface {

            public Baz2() {
            }
        }
        return new Baz2();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10695().create());
    }
}

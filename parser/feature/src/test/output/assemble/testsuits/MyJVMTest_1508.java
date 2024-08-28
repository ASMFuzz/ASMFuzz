public class MyJVMTest_1508 {

    static String name = "((y1)H*V,^";

    Class findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException("Why are you using this?");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1508().findClass(name));
    }
}

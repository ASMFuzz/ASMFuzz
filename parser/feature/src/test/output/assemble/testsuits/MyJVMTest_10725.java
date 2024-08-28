public class MyJVMTest_10725 {

    static String name = "d2x~@9`fwi";

    Class findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException("Why are you using this?");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10725().findClass(name));
    }
}

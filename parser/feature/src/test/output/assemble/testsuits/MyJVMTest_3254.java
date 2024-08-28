public class MyJVMTest_3254 {

    static String name = "[g>~i y!ot";

    Class findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3254().findClass(name));
    }
}

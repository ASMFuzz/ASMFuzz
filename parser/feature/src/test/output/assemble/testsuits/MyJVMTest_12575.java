public class MyJVMTest_12575 {

    static String name = ".J_kNKO89F";

    Class findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12575().findClass(name));
    }
}

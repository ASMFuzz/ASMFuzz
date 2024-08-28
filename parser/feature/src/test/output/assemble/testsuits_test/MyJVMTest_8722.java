public class MyJVMTest_8722 {

    static String name = "Srpr)9qJ/U";

    String checkName(String name) throws Exception {
        if (name == null || name.length() == 0) {
            throw new Exception("Invalid name");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8722().checkName(name);
    }
}

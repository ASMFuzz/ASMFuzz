public class MyJVMTest_6720 {

    static String name = "}joC8bF #|";

    String checkName(String name) throws Exception {
        if (name == null || name.length() == 0) {
            throw new Exception("Invalid name");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6720().checkName(name);
    }
}

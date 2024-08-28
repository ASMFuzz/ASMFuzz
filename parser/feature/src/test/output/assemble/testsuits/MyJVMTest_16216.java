public class MyJVMTest_16216 {

    static String name = "o/PnMr\\b, ";

    String checkName(String name) throws Exception {
        if (name == null || name.length() == 0) {
            throw new Exception("Invalid name");
        }
        return name;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16216().checkName(name);
    }
}

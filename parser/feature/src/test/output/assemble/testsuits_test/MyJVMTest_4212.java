public class MyJVMTest_4212 {

    static String name = "X{#blUxfE$";

    static String expected_re = "F=s1?{UGd|";

    String verifyProperty(String name, String expected_re) {
        String value = System.getProperty(name, "");
        System.out.print("Checking " + name + ": \"" + value + "\".matches(\"" + expected_re + "\")... ");
        if (!value.matches(expected_re)) {
            System.out.println("no.");
            throw new RuntimeException("FAIL: Wrong value for " + name + " property, \"" + value + "\", expected to be of form: \"" + expected_re + "\"");
        }
        System.out.println("yes.");
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4212().verifyProperty(name, expected_re));
    }
}

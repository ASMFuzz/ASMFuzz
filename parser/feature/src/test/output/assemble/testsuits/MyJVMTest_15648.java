public class MyJVMTest_15648 {

    static String message = "M'e=jE/!~D";

    static String myString = "._[Fz-E7tT";

    static TestStringObjectInitialization test = null;

    String add(String message) {
        myString += message;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15648().add(message);
    }
}

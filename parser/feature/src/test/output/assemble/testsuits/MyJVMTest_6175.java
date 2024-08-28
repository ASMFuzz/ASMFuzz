public class MyJVMTest_6175 {

    static String message = "@loI02pc^6";

    static String myString = "6HefwRDMgl";

    static TestStringObjectInitialization test = null;

    String add(String message) {
        myString += message;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6175().add(message);
    }
}

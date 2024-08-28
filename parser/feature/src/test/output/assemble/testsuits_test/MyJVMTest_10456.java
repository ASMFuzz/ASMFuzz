public class MyJVMTest_10456 {

    static String message = "{\"Ec6pt//&";

    static String myString = "r*M2^A1R,O";

    String add(String message) {
        myString += message;
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10456().add(message);
    }
}

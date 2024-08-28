public class MyJVMTest_18197 {

    static String message = "M3,H=Typ~A";

    String error(String message) {
        throw new RuntimeException(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18197().error(message);
    }
}

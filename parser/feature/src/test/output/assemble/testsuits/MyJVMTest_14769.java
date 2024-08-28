public class MyJVMTest_14769 {

    static String why = "4Uhu1N0=\"P";

    static String failure = "*fXQTw@tP$";

    String fail(String why) {
        System.out.println("FAIL: " + why);
        failure = why;
        return why;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14769().fail(why);
    }
}

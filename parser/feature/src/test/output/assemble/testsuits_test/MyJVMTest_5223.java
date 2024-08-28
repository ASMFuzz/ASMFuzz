public class MyJVMTest_5223 {

    static Object o1 = 348372236;

    static Object o2 = 4;

    static String reason = "s;,+OG\"7b8";

    static int numerrors = -1743165346;

    Object error(Object o1, Object o2, String reason) {
        System.err.println("Failed comparing: " + o1 + " to " + o2);
        System.err.println(reason);
        numerrors++;
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5223().error(o1, o2, reason);
    }
}

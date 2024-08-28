public class MyJVMTest_14642 {

    static Object o1 = 9;

    static Object o2 = 204561263;

    static String reason = "RONNH=asz-";

    static int numerrors = 0;

    Object error(Object o1, Object o2, String reason) {
        System.err.println("Failed comparing: " + o1 + " to " + o2);
        System.err.println(reason);
        numerrors++;
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14642().error(o1, o2, reason);
    }
}

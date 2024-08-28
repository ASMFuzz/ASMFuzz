public class MyJVMTest_12831 {

    static Object obj = 0;

    static String param = "OHq5 cR,<L";

    static int failed = 0;

    Object test(Object obj, String param) {
        try {
            obj.hashCode();
            System.out.println("OK: " + obj.getClass().getSimpleName() + ".hashCode worked with a null " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO!!! " + obj.getClass().getSimpleName() + ".hashCode got NPE with a null " + param);
            failed++;
        }
        try {
            obj.toString();
            System.out.println("OK: " + obj.getClass().getSimpleName() + ".toString worked with a null " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO!!! " + obj.getClass().getSimpleName() + ".toString got NPE.");
            failed++;
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12831().test(obj, param);
    }
}

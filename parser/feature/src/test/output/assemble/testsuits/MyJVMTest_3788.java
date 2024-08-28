public class MyJVMTest_3788 {

    static Object obj = 157428271;

    static String param = "eVdA&C(9Cs";

    static int failed = 0;

    Object test(Object obj, String param) {
        try {
            obj.hashCode();
            System.out.println("OK-1: " + obj.getClass().getSimpleName() + ".hashCode worked with a null paramer: " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO-1!!! " + obj.getClass().getSimpleName() + ".hashCode got NPE with null paramer: " + param);
            npe.printStackTrace();
            failed++;
        }
        try {
            obj.toString();
            System.out.println("OK-1: " + obj.getClass().getSimpleName() + ".toString worked with a null paramer: " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO-1!!! " + obj.getClass().getSimpleName() + ".toString got NPE with null paramer: " + param);
            npe.printStackTrace();
            failed++;
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3788().test(obj, param);
    }
}

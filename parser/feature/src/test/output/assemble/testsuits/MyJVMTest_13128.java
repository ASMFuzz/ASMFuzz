public class MyJVMTest_13128 {

    static Object obj = -1922485322;

    static String param = "@V:Z]nJ+>6";

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
        new MyJVMTest_13128().test(obj, param);
    }
}

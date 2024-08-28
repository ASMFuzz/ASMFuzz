public class MyJVMTest_4215 {

    static Object obj1 = 0;

    static Object obj2 = 0;

    static String param = "h]&WZ4n'2%";

    static int failed = 0;

    Object test(Object obj1, Object obj2, String param) {
        try {
            obj1.equals(obj2);
            System.out.println("OK-1: " + obj1.getClass().getSimpleName() + ".equals worked with a null paramer: " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO-1!!! " + obj1.getClass().getSimpleName() + ".equals got NPE with a null paramer: " + param);
            npe.printStackTrace();
            failed++;
        }
        try {
            obj2.equals(obj1);
            System.out.println("OK-2: " + obj2.getClass().getSimpleName() + ".equals worked with a null paramer: " + param);
        } catch (NullPointerException npe) {
            System.out.println("--->KO-2!!! " + obj2.getClass().getSimpleName() + ".equals got NPE with a null paramer: " + param);
            npe.printStackTrace();
            failed++;
        }
        try {
            obj1.equals(null);
            obj2.equals(null);
            System.out.println("OK-3: " + obj1.getClass().getSimpleName() + ".equals worked with a null field.");
        } catch (NullPointerException npe) {
            System.out.println("--->KO-3!!! " + obj1.getClass().getSimpleName() + ".equals got NPE with a null field.");
            npe.printStackTrace();
            failed++;
        }
        return obj1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4215().test(obj1, obj2, param);
    }
}

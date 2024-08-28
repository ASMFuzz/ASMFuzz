public class MyJVMTest_16767 {

    static Object[] o = { 7, -1936618198, 0, 0, 3, -456964467, 1004307779, 0, 3, 0 };

    static int nonStaticPublicField = 153765781;

    static int nonStaticFinalPublicField = 5;

    String arrayToString(Object[] o) {
        String s = "[";
        if (o == null || o.length == 0) {
            return s + "]";
        }
        for (int i = 0; i < o.length; i++) {
            s += o[i];
            if (i + 1 < o.length) {
                s += ",";
            }
        }
        return s + "]";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16767().arrayToString(o));
    }
}

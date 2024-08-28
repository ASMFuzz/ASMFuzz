public class MyJVMTest_7244 {

    static Object[] o = { 2, 0, 157518329, 2144689139, 0, 209797183, -1224924687, 4, 0, 0 };

    static int nonStaticPublicField = 7;

    static int nonStaticFinalPublicField = 962706143;

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
        System.out.println(new MyJVMTest_7244().arrayToString(o));
    }
}

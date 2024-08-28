public class MyJVMTest_15470 {

    static Object objArray = -1858548369;

    static int nonStaticPublicField = -2005669196;

    static int nonStaticFinalPublicField = -1978532309;

    String toOjectArrayString(Object objArray) {
        Object[] o = (Object[]) objArray;
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
        System.out.println(new MyJVMTest_15470().toOjectArrayString(objArray));
    }
}

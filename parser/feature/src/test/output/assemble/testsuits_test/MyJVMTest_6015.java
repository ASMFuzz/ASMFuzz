public class MyJVMTest_6015 {

    static Object objArray = 9;

    static int nonStaticPublicField = 0;

    static int nonStaticFinalPublicField = 0;

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
        System.out.println(new MyJVMTest_6015().toOjectArrayString(objArray));
    }
}

public class MyJVMTest_17523 {

    static Object o = 1047300029;

    Object printAnnotationValue(Object o) {
        if (o instanceof String) {
            System.out.print("\"" + o + "\"");
        } else {
            System.out.print(String.valueOf(o));
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17523().printAnnotationValue(o);
    }
}

public class MyJVMTest_7960 {

    static Object o = 5;

    Object printAnnotationValue(Object o) {
        if (o instanceof String) {
            System.out.print("\"" + o + "\"");
        } else {
            System.out.print(String.valueOf(o));
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7960().printAnnotationValue(o);
    }
}

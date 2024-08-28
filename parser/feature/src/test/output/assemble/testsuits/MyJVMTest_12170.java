public class MyJVMTest_12170 {

    static Object o = 5;

    String getClassStr(Object o) {
        if (o == null) {
            return "<null>";
        }
        return o.getClass().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12170().getClassStr(o));
    }
}

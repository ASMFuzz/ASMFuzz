public class MyJVMTest_2872 {

    static Object o = -400404147;

    String getClassStr(Object o) {
        if (o == null) {
            return "<null>";
        }
        return o.getClass().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2872().getClassStr(o));
    }
}

public class MyJVMTest_1246 {

    static Object o = -1541274544;

    String format(Object o) {
        return o == null ? "null" : o.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1246().format(o));
    }
}

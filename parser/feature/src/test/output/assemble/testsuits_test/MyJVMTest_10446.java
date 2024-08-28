public class MyJVMTest_10446 {

    static Object o = 575648397;

    String format(Object o) {
        return o == null ? "null" : o.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10446().format(o));
    }
}

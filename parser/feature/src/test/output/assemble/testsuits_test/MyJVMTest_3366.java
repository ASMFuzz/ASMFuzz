public class MyJVMTest_3366 {

    static Object o = -936238938;

    String m(Object o) {
        return "Object " + o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3366().m(o));
    }
}

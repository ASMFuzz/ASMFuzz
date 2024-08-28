public class MyJVMTest_12695 {

    static Object o = 7;

    String m(Object o) {
        return "Object " + o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12695().m(o));
    }
}

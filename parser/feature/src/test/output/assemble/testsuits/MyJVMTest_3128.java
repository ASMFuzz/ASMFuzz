public class MyJVMTest_3128 {

    static Object o = 1458778009;

    boolean zconv2(Object o) {
        return (boolean) o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3128().zconv2(o));
    }
}

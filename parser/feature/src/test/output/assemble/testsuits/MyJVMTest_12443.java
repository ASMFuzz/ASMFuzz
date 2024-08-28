public class MyJVMTest_12443 {

    static Object o = 8;

    boolean zconv2(Object o) {
        return (boolean) o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12443().zconv2(o));
    }
}

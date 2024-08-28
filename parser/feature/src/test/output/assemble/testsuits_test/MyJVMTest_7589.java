public class MyJVMTest_7589 {

    static String eParam1 = "K1CZsPc+cG";

    static Throwable e = new Throwable(eParam1);

    static Class<? extends Throwable> exc = null;

    boolean complyWith(Throwable e) {
        return exc.isAssignableFrom(e.getClass());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7589().complyWith(e));
    }
}

public class MyJVMTest_17135 {

    static String eParam1Param1 = "im\\}OU5u3i";

    static Throwable eParam1 = new Throwable(eParam1Param1);

    static Throwable e = new Throwable(eParam1);

    static Class<? extends Throwable> exc = null;

    boolean complyWith(Throwable e) {
        return exc.isAssignableFrom(e.getClass());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17135().complyWith(e));
    }
}

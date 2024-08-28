public class MyJVMTest_14635 {

    static Class<Double> cd = null;

    static Class<? extends double[]> cdarr = null;

    Class<? extends double[]> test(Class<Double> cd, Class<? extends double[]> cdarr) {
        ((false) ? cd : cdarr).toString();
        return cdarr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14635().test(cd, cdarr);
    }
}

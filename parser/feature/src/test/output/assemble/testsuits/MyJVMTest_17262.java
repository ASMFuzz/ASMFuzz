public class MyJVMTest_17262 {

    static String name = "d}w*+m:#jT";

    Object getProperty(String name) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17262().getProperty(name));
    }
}

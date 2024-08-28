public class MyJVMTest_15438 {

    Class<?> forName0() throws ClassNotFoundException {
        return Class.forName("java.lang.String");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15438().forName0());
    }
}

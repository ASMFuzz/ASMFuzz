public class MyJVMTest_5983 {

    Class<?> forName0() throws ClassNotFoundException {
        return Class.forName("java.lang.String");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5983().forName0());
    }
}

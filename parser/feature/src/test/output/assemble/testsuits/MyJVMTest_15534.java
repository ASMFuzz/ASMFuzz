public class MyJVMTest_15534 {

    Class<?> forName3() throws Exception {
        Class<?> clazz = null;
        try {
            return clazz = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15534().forName3());
    }
}

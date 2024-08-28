public class MyJVMTest_7972 {

    Class<?> forName1() throws Exception {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            return null;
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7972().forName1());
    }
}

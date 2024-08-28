public class MyJVMTest_17536 {

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
        System.out.println(new MyJVMTest_17536().forName1());
    }
}

public class MyJVMTest_3142 {

    Class<?> forName4() throws Exception {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            return null;
        } catch (RuntimeException e) {
            return null;
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3142().forName4());
    }
}

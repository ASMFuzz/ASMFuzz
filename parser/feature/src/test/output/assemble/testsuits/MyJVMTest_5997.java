public class MyJVMTest_5997 {

    Class<?> forName2() throws Exception {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.String");
            try {
                throw new Exception("das");
            } catch (Exception ex) {
            }
        } catch (ClassNotFoundException e) {
            return null;
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5997().forName2());
    }
}

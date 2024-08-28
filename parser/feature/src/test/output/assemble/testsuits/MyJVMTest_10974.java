public class MyJVMTest_10974 {

    Class<?> forName6() {
        Class<?> clazz = null;
        try {
            return Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
        }
        try {
            int k = 0;
        } catch (RuntimeException e) {
        }
        int i;
        try {
            return Class.forName("TOTO");
        } catch (ClassNotFoundException e) {
        }
        try {
            return Class.forName("TOTO");
        } catch (ClassNotFoundException e) {
        }
        try {
            return Class.forName("TOTO");
        } catch (ClassNotFoundException e) {
        }
        try {
            return Class.forName("TOTO");
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10974().forName6());
    }
}

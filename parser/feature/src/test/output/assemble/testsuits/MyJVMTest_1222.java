public class MyJVMTest_1222 {

    Class<?> forName5() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
        }
        int i;
        try {
            i = 0;
        } catch (Exception e) {
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1222().forName5());
    }
}

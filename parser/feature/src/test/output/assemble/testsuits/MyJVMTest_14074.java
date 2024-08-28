public class MyJVMTest_14074 {

    Class<?> negativeforName() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("jdk.internal.jimage.BasicImageReader");
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14074().negativeforName());
    }
}

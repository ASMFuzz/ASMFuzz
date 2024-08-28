public class MyJVMTest_14737 {

    Class<?> forName7() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("optim.AType");
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14737().forName7());
    }
}

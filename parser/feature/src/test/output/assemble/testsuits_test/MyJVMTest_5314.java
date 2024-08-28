public class MyJVMTest_5314 {

    Class<?> forName7() {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("optim.AType");
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5314().forName7());
    }
}

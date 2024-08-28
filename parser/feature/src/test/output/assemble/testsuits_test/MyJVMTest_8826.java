public class MyJVMTest_8826 {

    void run() {
        try {
            Class<?> c1 = Class.forName("Class1");
            Object o = c1.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Class Class1 not found.");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8826().run();
    }
}

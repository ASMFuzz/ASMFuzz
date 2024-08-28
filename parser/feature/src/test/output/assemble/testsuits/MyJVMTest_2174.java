public class MyJVMTest_2174 {

    void run() {
        try {
            Class<?> c2 = Class.forName("p.Class2");
            System.out.println("Signed jar loaded.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Class2 not found.");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2174().run();
    }
}

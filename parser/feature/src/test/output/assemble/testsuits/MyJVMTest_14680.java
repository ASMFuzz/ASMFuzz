public class MyJVMTest_14680 {

    void loadClasses() throws ClassNotFoundException {
        Class.forName("AllAbstract");
        Class.forName("AllNative");
        Class.forName("Abstract");
        Class.forName("Native");
        Class.forName("AbstractAndNative");
        Class.forName("Interface");
        Class.forName("InterfaceWithCode");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14680().loadClasses();
    }
}

public class MyJVMTest_16674 {

    void sayHello() {
        System.out.println("hello, world!");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16674().sayHello();
    }
}

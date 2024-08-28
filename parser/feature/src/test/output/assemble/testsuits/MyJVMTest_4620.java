public class MyJVMTest_4620 {

    String sayHello() {
        return "Hello";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4620().sayHello());
    }
}

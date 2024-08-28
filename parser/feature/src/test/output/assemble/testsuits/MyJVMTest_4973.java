public class MyJVMTest_4973 {

    A create() {
        return new A();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4973().create());
    }
}

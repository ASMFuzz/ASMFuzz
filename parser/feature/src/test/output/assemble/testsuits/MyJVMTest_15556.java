public class MyJVMTest_15556 {

    int get() {
        return 1;
    }

    int test() {
        Parent x = new Child();
        return x.get();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15556().test());
    }
}

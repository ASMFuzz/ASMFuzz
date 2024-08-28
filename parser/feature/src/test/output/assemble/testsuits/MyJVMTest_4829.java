public class MyJVMTest_4829 {

    C c() {
        return new C();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4829().c());
    }
}

public class MyJVMTest_17185 {

    Class<?> getAnonymousClass() {
        return new Object() {
        }.getClass();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17185().getAnonymousClass());
    }
}

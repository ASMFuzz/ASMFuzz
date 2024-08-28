public class MyJVMTest_7637 {

    Class<?> getAnonymousClass() {
        return new Object() {
        }.getClass();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7637().getAnonymousClass());
    }
}

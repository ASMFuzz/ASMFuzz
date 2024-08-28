public class MyJVMTest_14798 {

    boolean m() {
        return this.getClass() instanceof Class<?>;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14798().m());
    }
}

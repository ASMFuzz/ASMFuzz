public class MyJVMTest_5373 {

    boolean m() {
        return this.getClass() instanceof Class<?>;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5373().m());
    }
}

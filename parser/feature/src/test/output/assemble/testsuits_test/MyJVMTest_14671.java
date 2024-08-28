public class MyJVMTest_14671 {

    String name() {
        return this.getClass().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14671().name());
    }
}

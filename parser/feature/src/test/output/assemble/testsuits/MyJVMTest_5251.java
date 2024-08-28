public class MyJVMTest_5251 {

    String name() {
        return this.getClass().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5251().name());
    }
}

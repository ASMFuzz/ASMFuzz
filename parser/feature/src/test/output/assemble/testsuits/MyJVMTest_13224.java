public class MyJVMTest_13224 {

    I bar() {
        return (I) this;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13224().bar());
    }
}

public class MyJVMTest_3880 {

    I bar() {
        return (I) this;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3880().bar());
    }
}

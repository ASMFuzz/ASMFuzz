public class MyJVMTest_17955 {

    int doNothingInJava() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17955().doNothingInJava());
    }
}

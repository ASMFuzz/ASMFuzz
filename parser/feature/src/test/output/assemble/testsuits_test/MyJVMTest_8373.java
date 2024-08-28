public class MyJVMTest_8373 {

    int doNothingInJava() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8373().doNothingInJava());
    }
}

public class MyJVMTest_18055 {

    int not_inlined() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18055().not_inlined());
    }
}

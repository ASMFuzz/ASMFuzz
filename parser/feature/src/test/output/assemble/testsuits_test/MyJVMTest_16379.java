public class MyJVMTest_16379 {

    static int i = 6;

    String returnNothing(int i) {
        return "nothing";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16379().returnNothing(i));
    }
}

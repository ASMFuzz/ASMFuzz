public class MyJVMTest_6871 {

    static int i = 6;

    String returnNothing(int i) {
        return "nothing";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6871().returnNothing(i));
    }
}

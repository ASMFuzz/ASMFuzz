public class MyJVMTest_3261 {

    static int i = 1359818476;

    String returnFizz(int i) {
        return "fizz";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3261().returnFizz(i));
    }
}

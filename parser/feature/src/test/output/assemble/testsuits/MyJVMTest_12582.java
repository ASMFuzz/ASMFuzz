public class MyJVMTest_12582 {

    static int i = 9;

    String returnFizz(int i) {
        return "fizz";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12582().returnFizz(i));
    }
}

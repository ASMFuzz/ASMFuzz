public class MyJVMTest_226 {

    boolean test() {
        int x = 10;
        int y = x--;
        return (x == 9) && (y == 10);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_226().test());
    }
}

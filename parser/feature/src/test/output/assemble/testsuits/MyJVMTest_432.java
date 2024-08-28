public class MyJVMTest_432 {

    static int i = 8;

    int fcomp(int i) {
        return Integer.bitCount(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_432().fcomp(i));
    }
}

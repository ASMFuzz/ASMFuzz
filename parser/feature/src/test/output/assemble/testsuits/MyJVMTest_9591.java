public class MyJVMTest_9591 {

    static int i = 0;

    int fcomp(int i) {
        return Integer.bitCount(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9591().fcomp(i));
    }
}

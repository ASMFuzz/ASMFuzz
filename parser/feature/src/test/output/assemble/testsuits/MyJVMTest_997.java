public class MyJVMTest_997 {

    static int j = 2;

    int blahBlahBlah(int j) {
        return;
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_997().blahBlahBlah(j);
    }
}

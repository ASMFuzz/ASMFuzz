public class MyJVMTest_10185 {

    static int j = 1343915194;

    int blahBlahBlah(int j) {
        return;
        return j;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10185().blahBlahBlah(j);
    }
}

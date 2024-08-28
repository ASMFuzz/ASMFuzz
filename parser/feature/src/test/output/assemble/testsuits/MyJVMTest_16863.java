public class MyJVMTest_16863 {

    int getInt() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16863().getInt());
    }
}

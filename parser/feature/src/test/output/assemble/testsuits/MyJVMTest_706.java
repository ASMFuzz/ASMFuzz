public class MyJVMTest_706 {

    byte remi_sum() {
        Byte j = new Byte((byte) 1);
        for (int i = 0; i < 1000; i++) {
            j = new Byte((byte) (j + 1));
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_706().remi_sum());
    }
}

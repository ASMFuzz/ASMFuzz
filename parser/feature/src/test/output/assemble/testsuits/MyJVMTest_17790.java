public class MyJVMTest_17790 {

    String makeLongHexString() {
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 0; i < (1 << 30) - 1; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17790().makeLongHexString());
    }
}

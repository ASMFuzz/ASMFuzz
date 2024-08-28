public class MyJVMTest_18147 {

    String bigString() {
        String s = "";
        for (int lines = 0; ; ++lines) {
            for (int symbols = 0; symbols < 100; ++symbols) {
                s += "0";
            }
            if (lines < 50) {
                s += "\n";
            } else {
                break;
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18147().bigString());
    }
}

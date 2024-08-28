public class MyJVMTest_1620 {

    static String in = "%q.vGw: /M";

    static String text = "O(-F_DZtWr";

    String normalize(String in) {
        return in.replace(System.getProperty("line.separator"), "\n");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1620().normalize(in));
    }
}

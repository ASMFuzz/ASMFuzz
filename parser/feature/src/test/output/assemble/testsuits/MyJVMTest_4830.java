public class MyJVMTest_4830 {

    static String name = "NO NAME";

    int hasCode() {
        return name.hashCode();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4830().hasCode());
    }
}

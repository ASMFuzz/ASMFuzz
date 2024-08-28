public class MyJVMTest_11660 {

    static String option = "qq[\"Z&J~JF";

    int optionLength(String option) {
        System.out.println("option: " + option);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11660().optionLength(option));
    }
}

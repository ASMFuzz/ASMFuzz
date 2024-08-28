public class MyJVMTest_11263 {

    static int year = 5;

    static int _fCreationYear = 8;

    boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11263().isLeapYear(year));
    }
}

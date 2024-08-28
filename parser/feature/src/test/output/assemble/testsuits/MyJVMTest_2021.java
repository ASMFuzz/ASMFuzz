public class MyJVMTest_2021 {

    static int year = -1030766343;

    static int _fCreationYear = 0;

    boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2021().isLeapYear(year));
    }
}

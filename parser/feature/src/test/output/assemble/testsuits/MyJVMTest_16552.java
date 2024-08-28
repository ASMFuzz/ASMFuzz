public class MyJVMTest_16552 {

    static boolean leapYear = true;

    static int month = 1;

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static int _fCreationYear = 9;

    int daysInMonth(boolean leapYear, int month) {
        if (leapYear && month == 1)
            return DaysInMonth[month] + 1;
        else
            return DaysInMonth[month];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16552().daysInMonth(leapYear, month));
    }
}

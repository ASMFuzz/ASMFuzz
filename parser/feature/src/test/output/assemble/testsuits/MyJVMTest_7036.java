public class MyJVMTest_7036 {

    static boolean leapYear = true;

    static int month = 5;

    static byte[] DaysInMonth = new byte[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static int _fCreationYear = -405783819;

    int daysInMonth(boolean leapYear, int month) {
        if (leapYear && month == 1)
            return DaysInMonth[month] + 1;
        else
            return DaysInMonth[month];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7036().daysInMonth(leapYear, month));
    }
}

public class MyJVMTest_9885 {

    static boolean leapYear = false;

    static int month = 3;

    static int[] DaysInYear = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };

    static int _fCreationYear = -1111645152;

    int daysInYear(boolean leapYear, int month) {
        if (leapYear && month > 1)
            return DaysInYear[month] + 1;
        else
            return DaysInYear[month];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9885().daysInYear(leapYear, month));
    }
}

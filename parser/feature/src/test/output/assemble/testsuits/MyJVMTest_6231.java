import static java.util.Calendar.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyJVMTest_6231 {

    static int amount = 0;

    static int[] params = { -530610468, 721672008, 0, 1042304530, 5, 7, 4, 1768793494, 3, 3 };

    static int[] sequence = { 9, 0, 8, 1534326370, -1529523899, 6, 1300465800, -365999099, 6, -1265127375 };

    static int startIndex = 1052183672;

    static int errors = 5;

    Calendar testRoll(int amount, int[] params, int[] sequence, int startIndex) {
        int year = params[0];
        int month = params[1];
        int dayOfMonth = params[2];
        int hourOfDay = sequence[startIndex];
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, 0, 0);
        int ampm = cal.get(AM_PM);
        int length = sequence.length;
        int count = length * 2;
        int field = (length > 12) ? HOUR_OF_DAY : HOUR;
        System.out.printf("roll(%s, %2d) starting from %s%n", (field == HOUR) ? "HOUR" : "HOUR_OF_DAY", amount, cal.getTime());
        for (int i = 0; i < count; i++) {
            int index = (amount > 0) ? (startIndex + i + 1) % length : Math.floorMod(startIndex - i - 1, length);
            int expected = sequence[index];
            if (field == HOUR) {
                expected %= 12;
            }
            cal.roll(field, amount);
            int value = cal.get(field);
            if (value != expected) {
                System.out.println("Unexpected field value: got=" + value + ", expected=" + expected);
                errors++;
            }
            if (cal.get(DAY_OF_MONTH) != dayOfMonth) {
                System.out.println("DAY_OF_MONTH changed: " + dayOfMonth + " to " + cal.get(DAY_OF_MONTH));
            }
            if (field == HOUR && cal.get(AM_PM) != ampm) {
                System.out.println("AM_PM changed: " + ampm + " to " + cal.get(AM_PM));
                errors++;
            }
        }
        return cal;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6231().testRoll(amount, params, sequence, startIndex);
    }
}

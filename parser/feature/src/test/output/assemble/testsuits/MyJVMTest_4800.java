import java.util.Calendar;

public class MyJVMTest_4800 {

    void testCalendarBuilderToString() {
        CalendarBuilder calendarBuilder = new CalendarBuilder();
        calendarBuilder.set(Calendar.YEAR, 2020);
        calendarBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4800().testCalendarBuilderToString();
    }
}

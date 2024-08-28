public class MyJVMTest_10018 {

    static String message = "nCI08'p-T4";

    static String myName = "/TA1B-#^i ";

    java.text.NumberFormat logMessage(String message) {
        java.text.NumberFormat formatter = java.text.NumberFormat.getIntegerInstance();
        formatter.setMinimumIntegerDigits(2);
        java.util.Calendar c = java.util.Calendar.getInstance();
        System.out.println(formatter.format(c.get(java.util.Calendar.HOUR_OF_DAY)) + ":" + formatter.format(c.get(java.util.Calendar.MINUTE)) + ":" + formatter.format(c.get(java.util.Calendar.SECOND)) + " >> " + myName + " :: " + message);
        return formatter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10018().logMessage(message);
    }
}

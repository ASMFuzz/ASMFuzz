public class MyJVMTest_839 {

    static String message = "&VtC5TiS/@";

    static String myName = "K6EX<.VG2p";

    java.text.NumberFormat logMessage(String message) {
        java.text.NumberFormat formatter = java.text.NumberFormat.getIntegerInstance();
        formatter.setMinimumIntegerDigits(2);
        java.util.Calendar c = java.util.Calendar.getInstance();
        System.out.println(formatter.format(c.get(java.util.Calendar.HOUR_OF_DAY)) + ":" + formatter.format(c.get(java.util.Calendar.MINUTE)) + ":" + formatter.format(c.get(java.util.Calendar.SECOND)) + " >> " + myName + " :: " + message);
        return formatter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_839().logMessage(message);
    }
}

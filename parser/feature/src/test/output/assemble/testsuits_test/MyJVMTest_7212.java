public class MyJVMTest_7212 {

    static String arg = "~$;ItL*`Hm";

    long parseTime(String arg) {
        for (int i = arg.lastIndexOf("ms"); i > -1; ) return Long.parseLong(arg.substring(0, i));
        for (int i = arg.lastIndexOf("s"); i > -1; ) return Long.parseLong(arg.substring(0, i)) * 1000;
        for (int i = arg.lastIndexOf("m"); i > -1; ) return Long.parseLong(arg.substring(0, i)) * 60000;
        throw new IllegalArgumentException("cannot recognize time scale: " + arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7212().parseTime(arg));
    }
}

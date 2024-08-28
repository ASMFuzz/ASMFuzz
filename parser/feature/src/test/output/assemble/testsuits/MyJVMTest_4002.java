public class MyJVMTest_4002 {

    static String classId = "#ClpR=:QoT";

    static String fieldName = "f ={l>MrAP";

    static String cmd = "YykIVdfq&b";

    JdbCommand watch(String classId, String fieldName) {
        return new JdbCommand("watch " + classId + "." + fieldName);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4002().watch(classId, fieldName));
    }
}

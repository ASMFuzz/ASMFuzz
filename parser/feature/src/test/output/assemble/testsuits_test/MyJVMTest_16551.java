public class MyJVMTest_16551 {

    static String E1000G0HOSTNAME = "fe80:0:0:0:21b:24ff:febd:f29c%e1000g0";

    String getHostName() {
        return E1000G0HOSTNAME;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16551().getHostName());
    }
}

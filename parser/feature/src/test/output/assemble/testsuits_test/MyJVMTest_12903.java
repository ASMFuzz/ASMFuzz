public class MyJVMTest_12903 {

    String variant() {
        String vmName = System.getProperty("java.vm.name");
        if (vmName.endsWith(" Server VM")) {
            return "server";
        } else if (vmName.endsWith(" Client VM")) {
            return "client";
        } else if (vmName.endsWith(" Minimal VM")) {
            return "minimal";
        } else {
            throw new Error("TESTBUG: unsuppported vm variant");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12903().variant());
    }
}

public class MyJVMTest_15300 {

    static String msvName = "hm]:-h$hY.";

    int stringSwitch(String msvName) {
        int result = 0;
        switch(msvName) {
            case "FOO":
                result |= (1 << 0);
            case "BAR":
            case "BAZ":
                result |= (1 << 1);
                break;
            default:
                switch(msvName) {
                    case "QUX":
                        result |= (1 << 2);
                        break;
                    case "QUUX":
                        result |= (1 << 3);
                    default:
                        result |= (1 << 4);
                }
                result |= (1 << 5);
                break;
            case "MUMBLE":
                result |= (1 << 6);
                return result;
            case "FOOBAR":
                result |= (1 << 7);
                break;
        }
        result |= (1 << 8);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15300().stringSwitch(msvName));
    }
}

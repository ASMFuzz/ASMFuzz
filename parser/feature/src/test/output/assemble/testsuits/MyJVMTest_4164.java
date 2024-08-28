public class MyJVMTest_4164 {

    static String s = ":C7Qc1*<pd";

    int namedBreak(String s) {
        int result = 0;
        outer: switch(s) {
            case "a":
            case "b":
            case "c":
                result |= (1 << 0);
                inner: switch(s + s) {
                    case "aa":
                        result |= (1 << 1);
                        break inner;
                    case "cc":
                        break outer;
                    default:
                        result |= (1 << 2);
                        return result;
                }
            case "d":
                result |= (1 << 3);
                break outer;
            default:
                return result |= (1 << 4);
        }
        result |= (1 << 5);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4164().namedBreak(s));
    }
}

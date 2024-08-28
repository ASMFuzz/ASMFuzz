public class MyJVMTest_12869 {

    static String[] args = { "^f*5aL6rf#", "#[&UJF]1\"(", "\\dfh6ss6iP", "Q!GVt5Bb]8", "\\Vx\"`aznPL", "+/u`\\0qMX6", "w #a1Tl%F3", "$/\"\\>0AQY[", ";3Jk<M;d?O", "pre#3(9fS#" };

    String getExpectedValue(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("Wrong number of arguments. Expected 1 but got " + args.length);
        }
        return args[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12869().getExpectedValue(args));
    }
}

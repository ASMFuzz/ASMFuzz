public class MyJVMTest_6832 {

    static String[] args = { "V@7k#)gqZk", ">&FaFp;RKP", "<S\"zyEg#NC", "0~kc+V%%2,", "SHzU;)]%F#", "+Z-{#k dTS", "(BMudYfG;T", ":ivx[(}~)#", "9qF#LafSzy", "~WsAlls^dQ" };

    int parseAppointment(String[] args) {
        int timeout = -1, margin = 1;
        int timeouts = 0, waittimes = 0, margins = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (args[i].startsWith("-waittime=")) {
                    timeout = Integer.parseInt(args[i].substring(10));
                    waittimes++;
                }
                if (args[i].startsWith("-margin=")) {
                    margin = Integer.parseInt(args[i].substring(8));
                    margins++;
                }
            } else {
                if (i == 0) {
                    timeout = Integer.parseInt(args[i]);
                    timeouts++;
                }
            }
        }
        ;
        if (timeouts == 0 && waittimes == 0)
            throw new IllegalArgumentException("no $TIMEOUT, nor -waittime=$WAITTIME is set");
        if (waittimes > 1)
            throw new IllegalArgumentException("more than one -waittime=... is set");
        if (margins > 1)
            throw new IllegalArgumentException("more than one -margin=... is set");
        int result = timeout - margin;
        if (result <= 0)
            throw new IllegalArgumentException("delay appointment must be greater than " + margin + " minutes");
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6832().parseAppointment(args));
    }
}

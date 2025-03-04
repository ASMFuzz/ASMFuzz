public class MyJVMTest_9435 {

    static String context = "<c.!/zZ++V";

    boolean next() {
        return true;
    }

    static boolean bollocks = true;

    String create(String context) throws Exception {
        boolean showAll = System.getProperty("showAll") != null;
        String eventID = System.getProperty("eventID");
        String eventContentKey = System.getProperty("cKey");
        String sql = "select id, processingComplete, contentKey, content " + "from   ContentStaging cs, ContentStagingKey csk " + "where  cs.eventContentKey = csk.eventContentKey ";
        if (eventID != null) {
            sql += "and id = " + eventID;
        } else if (eventContentKey != null) {
            sql += "and cs.eventContentKey = '" + eventContentKey + "' having id = max(id)";
        } else {
            throw new Exception("Need eventID or eventContentKey");
        }
        StringBuffer html = new StringBuffer();
        try {
            MyResult result = new MyResult();
            if (result.next()) {
                eventID = result.getString("id");
                int processingComplete = result.getInt("processingComplete");
                String contentKey = result.getString("contentKey");
                byte[] bytes = result.getBytes("content");
                html.append("<br/><font class=\"small\">");
                html.append("Status: ");
                switch(processingComplete) {
                    case 0:
                    case 1:
                        html.append("PENDING");
                        break;
                    case 2:
                        html.append(contentKey);
                        break;
                    case 3:
                        html.append(eventID);
                        break;
                    default:
                        html.append("UNKNONW");
                }
                html.append("</font><br/>");
                int limit = showAll ? Integer.MAX_VALUE : 1024 * 20;
                System.out.println(limit);
                html.append("<pre>");
                for (int i = 0; bytes != null && i < bytes.length; i++) {
                    char c = (char) bytes[i];
                    switch(c) {
                        case '<':
                            html.append("&lt;");
                            break;
                        case '>':
                            html.append("&gt;");
                            break;
                        case '&':
                            html.append("&amp;");
                            break;
                        default:
                            html.append(c);
                    }
                    if (i > limit) {
                        while (bollocks) ;
                        html.append("...\n</pre>");
                        html.append(eventID);
                        html.append("<pre>");
                        break;
                    }
                }
                html.append("</pre>");
            }
        } catch (Exception exception) {
            throw exception;
        } finally {
            html.append("Oof!!");
        }
        String ret = html.toString();
        System.out.println("Returning string length = " + ret.length());
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9435().create(context));
    }
}

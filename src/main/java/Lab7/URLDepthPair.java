package Lab7;

public class URLDepthPair {
    private String url;
    private String host;
    private int depth;

    public static final String HTTP_PREFIX = "http://";
    public static final String A_PREFIX = "<a href=\"";

    URLDepthPair() {
        this.url = "";
        this.host = "";
        this.depth = 0;
    }

    URLDepthPair(String url) {
        this(url, "", 0);
    }

    URLDepthPair(String url, String host, int depth) {
        if (url.contains(A_PREFIX)) {
            if (url.length() > A_PREFIX.length()) {
                url = url.split("\"")[1];
                if (!url.contains(HTTP_PREFIX)) {
                    url = HTTP_PREFIX + host + url;
                }
            }
        }
        if (url.contains(HTTP_PREFIX)) {
            url = url.substring(url.indexOf(HTTP_PREFIX));
            if (url.contains("\"")) {
                url = url.split("\"")[1];
            }
        } else {
            url = "";
        }
        if (url.contains("#")) url = "";

        this.url = url;
        this.host = parseHost(url);
        this.depth = depth;

    }

    public String getUrl() {
        return url;
    }

    public String getHost() {
        return host;
    }

    public int getDepth() {
        return depth;
    }


    @Override
    public String toString() {
        return "url='" + url + '\'' + ", depth=" + depth;
    }

    private String parseHost(String url) {
        if (url.length() < HTTP_PREFIX.length()) return "";
        url = url.substring(HTTP_PREFIX.length());
        if (url.contains("/")) url = url.split("/")[0];
        return url;
    }
}

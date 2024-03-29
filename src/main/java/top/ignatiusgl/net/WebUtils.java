package top.ignatiusgl.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

/**
 * @Description: Built-in tools for handling web.
 * @author: IgnatiusGL
 * @date: 2022-06-11 10:10
 */
public class WebUtils {
    /**
     * Get the website source code from the url
     * <p>
     * Examples:
     * <blockquote><pre>
     *     getSource("www.baidu.com")
     * </pre></blockquote>
     * @param url the website url
     * @return return the string of source code. if url not access or other error, method will be return null
     */
    public static String getSource(String url) {
        String source = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
            httpURLConnection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Connection", "close");

            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                InputStreamReader inputStreamReader = new InputStreamReader(new GZIPInputStream(httpURLConnection.getInputStream()));
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                source = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return source;
    }
}

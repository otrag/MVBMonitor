package de.randec.MVBMonitor;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by olli on 30.01.15.
 */
public class Downloader {

    static String downloadJson (String url) throws IOException {
        String data = "";
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpResponse response = httpClient.execute(httpPost);
            data = EntityUtils.toString(response.getEntity(), "utf-8");
            //data = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        }
        //Unabhängig von gewählter Kodierung enthalten die json daten escape codes für die umlaute
        //z.B. &#228 für ä die unescape Methode wandelt sie wieder um
        return StringEscapeUtils.unescapeHtml4(data);

    }


}



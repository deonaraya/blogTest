package com.wordpress.blogTest.Helper;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chandrad on 8/19/17.
 */
public class CommonMethods {

    public static String getStatus(String url) throws Exception {

        String result = "";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
        } catch (Exception e) {
            result = "->Red<-";
            throw e;
        }
        return result;
    }
}

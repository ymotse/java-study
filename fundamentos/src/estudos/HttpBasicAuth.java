package estudos;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.catalina.util.Base64;

public class HttpBasicAuth {

public static void downloadFileWithAuth(String urlStr, String user, String pass, String outFilePath) {
    try {
    	
        URL url = new URL(urlStr);
        String authStr = user + ":" + pass;
        String authEncoded = Base64.encode(authStr.getBytes("UTF-8"));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Authorization", "Basic " + authEncoded);

        File file = new File(outFilePath);
        InputStream in = (InputStream) connection.getInputStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        //out.flush();
        out.close();
        in.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[]args){
	
	//downloadFileWithAuth("http://ec2-52-16-201-64.eu-west-1.compute.amazonaws.com/ZoneAnalyticsPerDay/83/?dateBegin=2015-11-04&dateEnd=2015-11-04/","virtualgate","vg813cou","//Users//Ninoo//Desktop//file01.json");
	downloadFileWithAuth("http://ec2-52-16-201-64.eu-west-1.compute.amazonaws.com/","virtualgate","vg813cou","//Users//Ninoo/Desktop//file01.json");
	
}

}
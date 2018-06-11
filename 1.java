
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASWATH
 */
public class twitter {
    public static void  main(String args[])
    {
        twitter s=new twitter();
        s.setter();
    }
    
    
    public String setter()
            {
                try
                {
                    URL url=new URL("http://www.twitter.com");
                    HttpURLConnection con=(HttpURLConnection) url.openConnection();
                    con.setReadTimeout(5000);
                    con.setRequestProperty("User-Agent", "Mozilla");
                    con.setRequestProperty("Referer", "google.com");
                    int status=con.getResponseCode();
                    boolean redirect=false;
                    if(status!=HttpURLConnection.HTTP_OK)
                    {
                        if(status==HttpURLConnection.HTTP_MOVED_PERM||status==HttpURLConnection.HTTP_MOVED_TEMP||status==HttpURLConnection.HTTP_SEE_OTHER)
                            redirect=true;
                    }
                    if(redirect)
                    {
                        String news=con.getHeaderField("Location");
                        String cookie=con.getHeaderField("Set_Cookie");
                        System.out.println(cookie);
                        con=(HttpURLConnection) new URL(news).openConnection();
                        con.setRequestProperty("User-Agent", "Mozilla");
                    con.setRequestProperty("Referer", "google.com");
                    }
                    BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String answer;
                    StringBuffer finals=new StringBuffer();
                    while((answer=br.readLine())!=null)
                    {
                        finals.append(answer);
                    }
                    System.out.println(finals);
                }
                catch(Exception e)
                {   
                    
                }
                return "";
            }
}

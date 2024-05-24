/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author root
 */
public class OTP {
    
    public  String generateOTP(int length) {  
        String numbers = "0123456789";  
        Random rndm_method = new Random();  
        char[] otp = new char[length];  
        for (int i = 0; i < length; i++) {  
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));  
        }  
        return new String(otp);  
    }  
    
    public  void sendOTP(String message , String number , String apiKey)
	{
            //generateOTP(4);
		try
		{
		String sendId="FSTSMS";
		String language="english";
		String route="p";
		
		message=URLEncoder.encode(message,"UTF-8");    //Important Step
		
		String myUrl="https://www.fast2sms.com/dev/bulkauthorization="+apiKey+"&sender_id="+sendId+"&+message="+message+"&language="+language+"&route="+route+"&numbers="+number;

		URL url=new URL(myUrl);
		HttpsURLConnection con= (HttpsURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent","Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		
		int responseCode=  con.getResponseCode();
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			
			if(line==null)
			{
				break;
			}
			
			response.append(line);
		}
		
		System.out.println(response);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

    
}
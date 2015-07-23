package msft3c;

//SSD

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.StringTokenizer;


import java.net.Inet4Address;
import java.net.UnknownHostException;


public class Solution {
  

  public static void main(String[] args) throws IOException {
       
      Scanner myScan = new Scanner(System.in);
      
      
      while (myScan.hasNextLine()) {
      String inputString = myScan.nextLine();
   
  String[] result = inputString.split("\\s");
  
  /*    for (int x=0; x<result.length; x++) {
        System.out.println(result[x]);
      }
  */
      

 if (parseNumericAddress(result[2]) == 0 )
   System.out.println("InValid");
  else  {
  if (!isInSubnet( result[0], result[1],  result[2]) )
   System.out.println("InRange");
  else 
   System.out.println("OutRange");
  }  
          
          
      }  //end of while
  }  //main

      public final static boolean isInSubnet(String ip1, String ip2, String ip3) {            
          if (validRange(ip1) <= validRange(ip2)  && validRange(ip2) <= validRange(ip3)) 
          return true;
          else return false;
          
      }
          
          public static long validRange(String ip) {
            
            String[] ipAddressInArray = ip.split("\\.");

  long result = 0;
for (int i = 0; i < ipAddressInArray.length; i++) {

      int power = 3 - i;
      int ipp = Integer.parseInt(ipAddressInArray[i]);
      result += ipp * Math.pow(256, power);

  }
            return result;
          }
          
   public final static int parseNumericAddress(String ipaddr) {
    //  Check if the string is valid
    if ( ipaddr == null || ipaddr.length() < 7 || ipaddr.length() > 15)
    return 0;
   //  Check the address string, should be n.n.n.n format
    StringTokenizer token = new StringTokenizer(ipaddr,".");
  if ( token.countTokens() != 4)
   return 0;

  int ipInt = 0;
  
  while ( token.hasMoreTokens()) {
    //  Get the current token and convert to an integer value
    String ipNum = token.nextToken();
    try {
      //  Validate the current address part
      int ipVal = Integer.valueOf(ipNum).intValue();
      if ( ipVal < 0 || ipVal > 255)
        return 0;
      //  Add to the integer address
      ipInt = (ipInt << 8) + ipVal;
    }
    catch (NumberFormatException ex) {
      return 0;
    }
  }
  //  Return the integer address
  return ipInt;
}  // parseNum



  
}  // class


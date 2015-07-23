package msft3c;


import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TestRun3 {   // this template  reads input from command line
    
    
    
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> hm = new HashMap<String, Double>();
        hm.put("Zara", new Double(3434.34));
        hm.put("Mahnaz", new Double(123.22));
        hm.put("Ayan", new Double(1378.00));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));
        
        
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
           
            Map.Entry<String, Double> me = (Map.Entry<String, Double>) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        
        Double dd = hm.get("Zara");
        hm.put("Zara", new Double (dd + 1000));
        System.out.print("Zara's new " + hm.get("Zara") );
        
    } // main
    
}
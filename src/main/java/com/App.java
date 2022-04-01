package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    Map<String,String> map = new HashMap<>();
    Map<String,String> hashTable = new Hashtable<>();
    Map<String,?> map1 = new HashMap<>();
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        App app = new App();
        app.createMAPData();
        app.createHashTableData();
        System.out.println(app.getMapData("Chatterjee"));
      //  BaseTest b = new BaseTest();
      //  b.invokeDriver();
    }

    public void createHashTableData()
    {
        hashTable.put("Tapa","Chatterjee");
        hashTable.put("Tapa","Chatterjee");
        hashTable.put("Chatterjee","Tapabrata");
       // hashTable.put(null,null);
        hashTable.forEach((k,v)->System.out.println(k+v));

      //  Iterator<String> iterator = new Iterator<String>();


    }

    public void createMAPData()
    { 
        map.put("Tapa","Chatterjee");
   //     map1.put("Chatterje",);
        map.put("Chatterjee","Shourya");
        map.put(null,null);
        map.forEach((k,v)->System.out.println(k+v)); 

        for(String key: map.keySet())
        {
            System.out.println("Key is"+key);
        }
        for (String value:map.values())
        {
            System.out.println("values:"+value);
        }
    }

    public String getMapData(String key)
    {
        return map.get(key);
    }
}

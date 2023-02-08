package org.example;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Files {

    public static void main(String[] args) throws FileNotFoundException {
        String path="C:\\Users\\Tringapps-user4\\Documents\\Paragraph.txt";
        File file = new File(path);
        Logger l=Logger.getLogger("com.api.jar");
        HashMap<String,Integer> map = new HashMap<>();

        Scanner sc = new Scanner(file);
        String word;
        while(sc.hasNext())
        {
            word = sc.next();
            if(map.containsKey(word))
            {
                int count = map.get(word) + 1;
                map.put(word,count);
            }
            else
            {
                map.put(word, 1);
            }
        }
        sc.close();
        l.log(Level.INFO,()->"The values in files are: "+ map);

        List<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();

        l.log(Level.INFO,()->"After Sorting the values in the file: "+ sorted);
    }

}
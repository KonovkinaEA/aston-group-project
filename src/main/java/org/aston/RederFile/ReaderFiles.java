package org.aston.RederFile;


import java.io.*;
import java.util.*;

import org.aston.model.*;
import org.aston.RederFile.Parse.*;

public class ReaderFiles<T>  {


    public List<T> ReadFiles(T f,String filePath ) {
        List<T> list = new ArrayList<T>();
        try (FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if((line.indexOf("Bus")>=0)&&(f.getClass()==Bus.class))
                {
                    BusParser bs = new BusParser();
                    list.add((T) bs.parse(line));
                }

                if((line.indexOf("Student")>=0)&&(f.getClass()==Student.class))
                {
                    StudentParser bs = new StudentParser();
                    list.add((T) bs.parse(line));
                }

                if((line.indexOf("User")>=0)&&(f.getClass()==User.class))
                {
                    UserParser bs = new UserParser();
                    list.add((T) bs.parse(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }
}


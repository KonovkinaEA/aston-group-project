package org.aston.reader_file;


import java.io.*;
import java.util.*;

import org.aston.model.*;
import org.aston.reader_file.parse.*;

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
                    BusParser bus = new BusParser();
                    list.add((T) bus.parse(line));
                }

                if((line.indexOf("Student")>=0)&&(f.getClass()==Student.class))
                {
                    StudentParser student = new StudentParser();
                    list.add((T) student.parse(line));
                }

                if((line.indexOf("User")>=0)&&(f.getClass()==User.class))
                {
                    UserParser user = new UserParser();
                    list.add((T) user.parse(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }
}


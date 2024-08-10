package org.aston.RederFile;


import java.io.*;
import java.util.*;

import org.aston.model.*;

public class ReaderFiles<T>  {




    ///choice - Enter which class we are looking for(Bus/User/Student)
    public List<T> ReadFiles(T f) {
        String filePath = ".\\Resurs\\file.txt";
        List<T> list = new ArrayList<T>();
        String FieldClass1 = "";
        String FieldClass2 = "";
        String FieldClass3 ="";
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;


            while ((line = bufferedReader.readLine()) != null)
            {

                FieldClass1 = "";
                FieldClass2 = "";
                FieldClass3 ="";

                int switchClass = 0;

                int  switchFieldClass = 0;

                if((line.indexOf("Bus")>=0)&&(f.getClass()==Bus.class))
                {
                    switchClass=1;

                    line =	line.replace("Bus = ","");
                }

                if((line.indexOf("Student")>=0)&&(f.getClass() == Student.class))
                {
                    switchClass=2;

                    line =	line.replace("Student = ","");
                }

                if((line.indexOf("User")>=0)&&(f.getClass() == User.class))
                {
                    switchClass=3;
                    line =	line.replace("User = ","");
                }

                char[] charArray = line.toCharArray();
                for (char chr : charArray) {
                    if ((chr != ',' )&&(chr != '\n')) {
                        if(switchFieldClass == 0)
                            FieldClass1 += chr;
                        if(switchFieldClass == 1) {
                            FieldClass2 += chr;
                        }
                        if(switchFieldClass == 2) {
                            FieldClass3 +=chr;

                        }
                    }
                    else
                    {
                        switchFieldClass++;
                    }

                }
                if(switchClass==1)
                {
                    Bus bus = new Bus.Builder().setNumber(FieldClass1).setModel(FieldClass2).setMileage(Integer.parseInt(FieldClass3.trim())).build();
                    list.add((T) bus);
                }
                if(switchClass==2)
                {
                    Student student = new Student.Builder().setGroupNumber(FieldClass1).setAverageGrade(Double.parseDouble(FieldClass2)).setRecordBookNumber(FieldClass3).build();
                    list.add((T) student);
                }
                if(switchClass==3)
                {
                    User user = new User.Builder().setName(FieldClass1).setPassword(FieldClass2).setEmail(FieldClass3).build();
                    list.add((T) user);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }
}


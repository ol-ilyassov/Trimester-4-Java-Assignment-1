// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
// at com.company.MyThread.run(MyThread.java:24)
// The error can be solved, with:
//   String[] column = line.split(",", 6);
// in MyThread.java; on line 23.
// But then, in file "report.csv", there will be dumb row as: 460.0,1,,,0,
// Because one of the source files has incorrect row format.

package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Publisher> publishersList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        // Work with Files and Threads
        int count = new File("articles").list().length;
        for (int i = 1; i <= count; i++) {
            MyThread thread = new MyThread("articles/part" + i + ".csv");
            thread.start();
            thread.join();
        }
        // Create "report.csv"
        FileWriter wrt= new FileWriter("report.csv");
        wrt.append("name,id,published_from,published_to,avg_content_length\n");
        int avgContentLength;
        for (Publisher p: publishersList) {
            wrt.append(p.getName()).append(",");
            wrt.append(p.getId()).append(",");
            wrt.append(p.getPublishedFrom()).append(",");
            wrt.append(p.getPublishedTo()).append(",");
            avgContentLength = p.getTotalContentLength()/p.getCount();
            wrt.append(avgContentLength + "\n");
        }
        wrt.flush();
        wrt.close();
        // Final Message
        System.out.println("\n\tThe location of \"report.csv\" file is in root folder of Project");
    }
}

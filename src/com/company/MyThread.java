package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
    private String path;

    public MyThread(String pathname) {
        path = pathname;
    }

    @Override
    public void run() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                String[] column = line.split(",");
                processArticle(column[1], column[2], column[4], column[5]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void processArticle(String source_id, String name, String content, String publish_date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date1;
        Date date2;
        boolean flag = false;
        for (Publisher p: Main.publishersList) {
            if (p.getId().equals(source_id)) {
                p.addContentLength(content.length());
                p.incCount();
                date1 = sdf.parse(p.getPublishedFrom());
                date2 = sdf.parse(publish_date);
                if (date1.compareTo(date2) > 0) { p.setPublishedFrom(publish_date); }
                date1 = sdf.parse(p.getPublishedTo());
                date2 = sdf.parse(publish_date);
                if (date1.compareTo(date2) < 0) { p.setPublishedTo(publish_date); }
                flag = true;
            }
        }
        if (flag == false) {
            Main.publishersList.add(new Publisher(name, source_id, publish_date, publish_date, content.length()));
        }
    }
}

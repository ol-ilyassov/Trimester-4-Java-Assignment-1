package com.company;

public class Publisher {
    private String name;
    private String id;
    private String publishedFrom;
    private String publishedTo;
    private int totalContentLength;
    private int count;

    public Publisher(String name, String id, String publishedFrom, String publishedTo, int totalContentLength) {
        this.name = name;
        this.id = id;
        this.publishedFrom = publishedFrom;
        this.publishedTo = publishedTo;
        this.totalContentLength = totalContentLength;
        count = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishedFrom() {
        return publishedFrom;
    }

    public void setPublishedFrom(String publishedFrom) {
        this.publishedFrom = publishedFrom;
    }

    public String getPublishedTo() {
        return publishedTo;
    }

    public void setPublishedTo(String publishedTo) {
        this.publishedTo = publishedTo;
    }

    public int getTotalContentLength() {
        return totalContentLength;
    }

    public void addContentLength(int contentLength) {
        totalContentLength += contentLength;
    }

    public int getCount() {
        return count;
    }

    public void incCount() {
        count++;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", published_from='" + publishedFrom + '\'' +
                ", published_to='" + publishedTo + '\'' +
                ", total_content_length=" + totalContentLength +
                ", count=" + count +
                "}\n";
    }
}

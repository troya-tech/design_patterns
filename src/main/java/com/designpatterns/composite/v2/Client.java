package com.designpatterns.composite.v2;

public class Client {

    public static void main(String[] args){

        FileSystemComponent file = new File("file1.txt");

        Directory directory1 = new Directory("d1");
        directory1.add(file);

        Directory root = new Directory("root");
        root.add(directory1);

        root.showDetails();
    }

}

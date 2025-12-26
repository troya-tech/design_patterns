package org.example.composite;


public class Client {
    public static void main(String[] args) {

        FileSystemComponent file1 = new File("resume.pdf");
        FileSystemComponent file2 = new File("photo.jpg");

        Directory documents = new Directory("Documents");
        documents.add(file1);

        Directory root = new Directory("Root");
        root.add(documents);
        root.add(file2);

        // Client treats file & directory the same
        root.showDetails();
    }
}

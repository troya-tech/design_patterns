package com.designpatterns.composite.v2;


import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component){
        this.children.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("directory:" + name);
        for(FileSystemComponent c : children){
            c.showDetails();
        }

    }
}

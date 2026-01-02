package com.bre;

public class MessageDropper {
    private Boolean dropped;

    public MessageDropper(){
        this.dropped =false;
    }

    @BreField(label = "isDropped", mutability = Mutability.READONLY,
            description = "Get the message from future procesjsing")
    public Boolean isDropped(){
        return this.dropped;
    }
}

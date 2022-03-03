package com.example.myapplication;

public class RowItem {

    private String name;
    private boolean show_checkBox;
    public RowItem(String name,boolean show_checkBox)
    {
        this.name=name;
        this.show_checkBox=show_checkBox;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setShow_checkBox(boolean show_checkBox)
    {
        this.show_checkBox = show_checkBox;
    }

    public String getName() {
        return name;
    }

    public boolean isShow_checkBox() {
        return show_checkBox;
    }
}

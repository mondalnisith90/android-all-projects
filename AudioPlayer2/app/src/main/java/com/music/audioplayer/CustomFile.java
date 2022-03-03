package com.music.audioplayer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.File;

public class CustomFile
{
    private File file;
    private boolean selectedMark;
    private boolean directory;
    private boolean threeDotIcon;
    private Drawable drawable;
    public CustomFile(File file,boolean selectedMark,boolean directory,boolean threeDotIcon,Drawable drawable)
    {
        this.file=file;
        this.selectedMark=selectedMark;
        this.directory=directory;
        this.threeDotIcon=threeDotIcon;
        this.drawable=drawable;

    }

    public boolean isThreeDotIconVisivle() {
        return threeDotIcon;
    }

    public void setThreeDotIconVisibility(boolean value)
    {
        this.threeDotIcon=value;
    }

    public void setDrawable(Bitmap bitmap) {
        this.drawable = drawable;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public boolean isSelectedMark() {
        return selectedMark;
    }

    public File getFile() {
        return file;
    }

    public void setSelectedMark(boolean selectedMark) {
        this.selectedMark = selectedMark;
    }
}

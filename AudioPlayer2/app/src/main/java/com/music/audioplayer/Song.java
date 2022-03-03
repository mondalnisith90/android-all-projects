package com.music.audioplayer;

import android.annotation.SuppressLint;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Song
{

    public ArrayList<File> getFoldersContainingMp3File(File storagePath)
    {
        ArrayList<File> folders=new ArrayList<File>();
        File []fileList=storagePath.listFiles();
        for (File file:fileList)
        {
            if (file.isDirectory() && !file.isHidden())
            {
                folders.addAll(getFoldersContainingMp3File(file));
            }
            else if (file.getName().endsWith(".mp3"))
            {
                folders.add(file.getParentFile());
                break;
            }
        }
        return folders;
    }

    public String getFileName(File file)
    {
        return file.getName();
    }

    public String getFilePath(File file)
    {
        return file.getAbsolutePath();
    }


    private int getAFolderMp3FilesNumber(File folder)
    {
        int filesNumber=0;
        File []fileList=folder.listFiles();
        for (File file:fileList)
        {
           if (file.getName().endsWith(".mp3"))
           {
               filesNumber=filesNumber+1;
           }
        }
        return filesNumber;
    }


    public String[] getSingleLevelFolderItemsNumber(ArrayList<File> allFolders)
    {
        String []folderItemsNumber=new String[allFolders.size()];
        for (int i=0;i<allFolders.size();i++)
        {
            folderItemsNumber[i]= String.valueOf(getAFolderMp3FilesNumber(allFolders.get(i)));
        }

        return folderItemsNumber;
    }

    public String getFolderItemsNumber(File folder)
    {
        String itemNumbers;
       itemNumbers =String.valueOf(getAFolderMp3FilesNumber(folder));
       return itemNumbers;
    }



    public String getHighericalFolderItemsNumber(File folder)
    {

        return getAFolferAllItemsNumber(folder);

    }


    private String getAFolferAllItemsNumber(File folder)
    {
        int itemsNumber=0;
        if (folder.exists()){
           File []allItems=folder.listFiles();
           for (File file:allItems)
           {
               if (file.isDirectory()){
                   if (isFolderContainingMp3Files(file)){
                       itemsNumber++;
                   }
               }else if (file.getName().endsWith(".mp3")){
                   itemsNumber++;
               }
           }
           }
           return String.valueOf(itemsNumber);

    }


    public ArrayList<File> getFolderMp3Songs(File folderName)
    {
        ArrayList<File> allMp3Songs=new ArrayList<File>();
        File []files=folderName.listFiles();
        for (File file:files)
        {
            if (file.getName().endsWith(".mp3"))
            {
                allMp3Songs.add(file);
            }
        }
        return allMp3Songs;
    }

    @SuppressLint("DefaultLocale")
    public String getFileSize(File file)
    {
        double size=file.length()/1048576.0;
        return String.format("%.2f",size);
    }

    @SuppressLint("DefaultLocale")
    public String[] getAllSongSize(ArrayList<File> files)
    {
        String allSongSize[]=new String[files.size()];
        double size;
        for(int i=0;i<files.size();i++)
        {
            size=files.get(i).length()/1048576.0;
            allSongSize[i]= String.format("%.2f",size);
        }

        return allSongSize;
    }

    @SuppressLint("DefaultLocale")
    public String[] getAllFileSize(ArrayList<File> files)
    {
        String allFileSize[]=new String[files.size()];
        double size;
        for(int i=0;i<files.size();i++)
        {
            size=files.get(i).length()/1048576.0;
            allFileSize[i]= String.format("%.2f",size);
        }

        return allFileSize;
    }


    @SuppressLint("SimpleDateFormat")
    public String getFileDateTimeInfo(File file)
    {
        String time;
        long milliSecond;
        SimpleDateFormat simpleDateFormat;
        time=""+file.lastModified();
        milliSecond=Long.parseLong(time);
        simpleDateFormat=new SimpleDateFormat("MMMM/dd/yyyy  HH:mm");
       return simpleDateFormat.format(new Date(milliSecond));

    }

    @SuppressLint("SimpleDateFormat")
    public String[] getAllSongDateTimeInfo(ArrayList<File> files)
    {
        String time;
        long milliSecond;
        String allSongDateTimeInfo[]=new String[files.size()];
        SimpleDateFormat simpleDateFormat;
        for (int i=0;i<files.size();i++)
        {
            time=""+files.get(i).lastModified();
            milliSecond=Long.parseLong(time);
            simpleDateFormat=new SimpleDateFormat("MMMM/dd/yyyy  HH:mm");
             allSongDateTimeInfo[i]=simpleDateFormat.format(new Date(milliSecond));
        }
        return allSongDateTimeInfo;
    }

    @SuppressLint("SimpleDateFormat")
    public String[] getAllFoldersDateTimeInfo(ArrayList<File> folders)
    {
        String time;
        long milliSecond;
        String allFoldersDateTimeInfo[]=new String[folders.size()];
        SimpleDateFormat simpleDateFormat;
        for (int i=0;i<folders.size();i++)
        {
            time=""+folders.get(i).lastModified();
            milliSecond=Long.parseLong(time);
            simpleDateFormat=new SimpleDateFormat("MMMM/dd/yyyy  HH:mm");
            allFoldersDateTimeInfo[i]=simpleDateFormat.format(new Date(milliSecond));
        }
        return allFoldersDateTimeInfo;
    }


    public ArrayList<File> getAllSongFile(ArrayList<File> folders)
    {
        ArrayList<File> allSongFile=new ArrayList<File>();
        for (File folder:folders)
        {
            allSongFile.addAll(getFolderMp3Songs(folder));
        }
        return allSongFile;
    }

    public String[] getAllSongName(ArrayList<File> allSongFile)
    {
        String []allSongName=new String[allSongFile.size()];
        for (int i=0;i<allSongFile.size();i++)
        {
            allSongName[i]=allSongFile.get(i).getName();
        }
        return allSongName;
    }

    public String[] getAllFoldersName(ArrayList<File> folders)
    {
        String []allFoldersName=new String[folders.size()];
        for (int i=0;i<folders.size();i++)
        {
            allFoldersName[i]=folders.get(i).getName();
        }
        return allFoldersName;
    }

    public String[] getAllFilePath(ArrayList<File> files)
    {
       String []allFilePath=new String[files.size()];
       for (int i=0;i<files.size();i++)
        {
            allFilePath[i]=files.get(i).getAbsolutePath();
        }
       return allFilePath;
    }

    public String[] getAllFoldersPath(ArrayList<File> folders)
    {
        String []allFoldersPath=new String[folders.size()];
        for (int i=0;i<folders.size();i++)
        {
            allFoldersPath[i]=folders.get(i).getAbsolutePath();
        }
        return allFoldersPath;
    }

    //All Methods For Folder Higherci

    public ArrayList<File> getRootFoldersContainingMp3Files(File storagePath)
    {
        ArrayList<File> allRootFoldersContainingMp3Files=new ArrayList<File>();
        ArrayList<File> mp3Files=new ArrayList<File>();
        File []filesList=storagePath.listFiles();
        if (filesList!=null)
        {
            for (File file : filesList)
            {
                if (file.getName().endsWith(".mp3"))
                {
                    mp3Files.add(file);
                }
                else
                {
                    if (isFolderContainingMp3Files(file))
                    {
                        allRootFoldersContainingMp3Files.add(file);
                    }
                }

            }
            allRootFoldersContainingMp3Files.addAll(mp3Files);
        }

        return allRootFoldersContainingMp3Files;
    }



    public boolean isFolderContainingMp3Files(File folder) {
        boolean checkedValue = false;
        File[] filesList = folder.listFiles();
        if (filesList != null)
        {
            for (File file:filesList)
            {
                    if (file.isDirectory() && !file.isHidden()) {
                        checkedValue = isFolderContainingMp3Files(file);
                        if (checkedValue) {
                            break;
                        }
                    } else if (file.getName().endsWith(".mp3"))
                    {
                        checkedValue = true;
                        break;
                    }
                }
            }
            return checkedValue;
        }


    }


package com.example.audioplayer;

class MilliTime {
        private long second;
        private long minute;
        private long hour;
        private String time;

    public String getTime(long millisecond)
    {
        second=millisecond/1000;
        minute=second/60;
        hour=minute/60;
        time=hour%24+" : "+minute%60+" : "+second%60;
        return time;
    }
    }


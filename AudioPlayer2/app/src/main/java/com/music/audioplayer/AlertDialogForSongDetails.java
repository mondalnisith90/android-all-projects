package com.music.audioplayer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class AlertDialogForSongDetails extends AppCompatDialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.song_details_alert_dialog_layout,null);
        TextView fileName,fileLocation,fileSize,fileDateTimeInfo,artist,album;
        fileName=view.findViewById(R.id.file_name);
        fileLocation=view.findViewById(R.id.file_location);
        fileSize=view.findViewById(R.id.file_size);
        fileDateTimeInfo=view.findViewById(R.id.date_time);
        artist=view.findViewById(R.id.artist);
        album=view.findViewById(R.id.album);
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(getContext());
        dialogBuilder.setTitle("File Information")
        .setView(view)
        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return dialogBuilder.create();

    }
}

package com.music.audioplayer;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.File;
import java.util.List;
import java.util.zip.Inflater;

public class AlertDialogForDelete extends AppCompatDialogFragment
{
    private TextView title,size,type;
    private String path;
    private boolean isDelete=false;

    @SuppressLint("ValidFragment")
    public AlertDialogForDelete(String path)
    {
        this.path=path;
    }
    public AlertDialogForDelete(){}


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater layoutInflater=getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.alert_dialog_for_delete,null);
        title=view.findViewById(R.id.file_name);
        size=view.findViewById(R.id.file_size);
        type=view.findViewById(R.id.file_type);
        setDialogTextViews(path);
        return createDialog(view);

    }



    private void setDialogTextViews(String path)//This Method Just For Reducing The Code in onCreateDialog()
    {
        File file=new File(path);
        if (file.exists())
        {
            Song song=new Song();
            title.setText(song.getFileName(file));
            size.setText("File Size: "+song.getFileSize(file)+" MB");
            type.setText("File Type: .mp3");
        }
    }

    private Dialog createDialog(View view)//This Method Just For Reducing The Code in onCreateDialog()
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Are You Sure To Delete This File?");
        alertDialog.setView(view);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (deleteFile(path))
                {
                    Toast.makeText(getContext(),"File is Delete",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getContext(),"File not Delete ",Toast.LENGTH_LONG).show();
                }

            }
        });

        alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return alertDialog.create();
    }

    private boolean deleteFile(String path)
    {
        boolean isFileDeleted=true;
        File file=new File(path);
        if (file.exists())
        {
            final String[] NECESSARY_PERMISSION=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
            if ((ContextCompat.checkSelfPermission(getContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED))
            {

                try {
                    isDelete=file.delete();
                    Log.e("ERREE","try block is Called");
                }
                catch (Exception e)
                {}
            }
        }

        return isDelete;
    }


    private void permission(final File file)
    {
        Dexter.withActivity(getActivity())
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        if (report.areAllPermissionsGranted())
                        {
                            try {
                                 isDelete=file.delete();
                            }
                            catch (Exception e)
                            {}

                        }
                        if (report.isAnyPermissionPermanentlyDenied())
                        {

                        }

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

                        token.continuePermissionRequest();
                    }
                }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {
                Toast.makeText(getContext(),"SOME ERROR",Toast.LENGTH_LONG).show();
            }
        }).onSameThread()
                .check();
    }

}

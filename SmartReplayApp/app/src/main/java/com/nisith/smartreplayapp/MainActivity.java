package com.nisith.smartreplayapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseSmartReply;
import com.google.firebase.ml.naturallanguage.smartreply.FirebaseTextMessage;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestion;
import com.google.firebase.ml.naturallanguage.smartreply.SmartReplySuggestionResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText localUserEditText, remoteUserEditText;
    private ImageView localUserSendIcon, remoteUserSendIcon;
    private TextView localUserOptionsTextView, remoteUserOptionsTextView, localReceivedMessage, remoteReceivedMessage;
    private List<FirebaseTextMessage> conversation;
    private String remoteUserId = "tapas12345";
    private FirebaseSmartReply smartReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localUserEditText = findViewById(R.id.local_user_edit_text);
        remoteUserEditText = findViewById(R.id.remote_user_edit_text);
        localUserSendIcon = findViewById(R.id.local_send_image_view);
        remoteUserSendIcon = findViewById(R.id.remote_send_image_view);
        localUserOptionsTextView = findViewById(R.id.local_user_options);
        remoteUserOptionsTextView = findViewById(R.id.remote_user_options);
        localReceivedMessage = findViewById(R.id.local_received_message);
        remoteReceivedMessage = findViewById(R.id.remote_received_message);
        conversation = new ArrayList<>();
        localUserSendIcon.setOnClickListener(new MyClickListener());
        remoteUserSendIcon.setOnClickListener(new MyClickListener());
//        conversation.add(FirebaseTextMessage.createForLocalUser(
//                "hello alex", System.currentTimeMillis() ));
        smartReply = FirebaseNaturalLanguage.getInstance().getSmartReply();

    }

    private class MyClickListener implements View.OnClickListener{
        public void onClick(View view){
            switch (view.getId()){
                case R.id.local_send_image_view:
                    localSendImageViewClick();
                    break;
                case R.id.remote_send_image_view:
                    remoteSendImageViewClick();
                    break;
            }
        }
    }

    private void localSendImageViewClick(){
        String text = localUserEditText.getText().toString().trim();
        if (text.isEmpty()){
            localUserEditText.setError("Write your Messages");
            localUserEditText.requestFocus();
        }else {
            conversation.add(FirebaseTextMessage.createForLocalUser(
               text, System.currentTimeMillis() ));
            remoteReceivedMessage.setText(text);
            remoteUserEditText.setText("");

        }

    }

    private void remoteSendImageViewClick(){
        String text = remoteUserEditText.getText().toString().trim();
        if (text.isEmpty()){
            remoteUserEditText.setError("Write your Messages");
            remoteUserEditText.requestFocus();
        }else {
            conversation.add(FirebaseTextMessage.createForRemoteUser(
                    text, System.currentTimeMillis(), remoteUserId));
            localReceivedMessage.setText(text);
            showOptions();
            localUserEditText.setText("");
        }
    }

    private void showOptions(){

        smartReply.suggestReplies(conversation)
                .addOnSuccessListener(new OnSuccessListener<SmartReplySuggestionResult>() {
                    @Override
                    public void onSuccess(SmartReplySuggestionResult result) {
                        if (result.getStatus() == SmartReplySuggestionResult.STATUS_NOT_SUPPORTED_LANGUAGE){
                            Log.d("ABCD","Language Not Support");
                        }else if (result.getStatus() == SmartReplySuggestionResult.STATUS_SUCCESS){
                            List<SmartReplySuggestion> smartReplySuggestions = result.getSuggestions();
                            if (smartReplySuggestions.size() > 0){
                                String text = "";
                                for (SmartReplySuggestion suggestion : smartReplySuggestions){
                                    text = text + suggestion.getText() + "\n";
                                }
                                localUserOptionsTextView.setText(text);
                            }else {
                                Log.d("ABCD", "No Suggestion Available");
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("ABCD", e.getMessage());
                    }
                });
    }


}

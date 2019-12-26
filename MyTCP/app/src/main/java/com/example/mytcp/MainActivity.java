package com.example.mytcp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.AsyncTask;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {

    TextView txtACK;
    EditText txtUserName;
    EditText txtUserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        txtUserName = findViewById(R.id.txtUserName);
        txtUserPass = findViewById(R.id.txtUserPass);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTCPClient myTCPClient = new MyTCPClient();
                myTCPClient.execute(txtUserName.getText().toString()+"_"+txtUserPass.getText().toString());
            }
        });
    }// End on Create

    private class MyTCPClient extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... data) {
            Socket socket;
            try{
                socket = new Socket("10.80.82.247", 2169); // (ip, port)
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(data[0]); //send data
//                txtACK.setText("Received: "+ in.readUTF());
            }catch(Exception e){
                //
            }
            return null;
        }

    }
}// End of Class

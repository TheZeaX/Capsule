package net.ddns.thezeax.capsule;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageReceiver implements Runnable{

    /*Context c;
    public MessageReceiver(Context context) {
        c = context;
    }*/

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    String message;
    Handler handler = new Handler();


    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(3033);
            while(true) {
                socket = serverSocket.accept();
                dataInputStream = new DataInputStream(socket.getInputStream());
                message = dataInputStream.readUTF();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.getContext(), message, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

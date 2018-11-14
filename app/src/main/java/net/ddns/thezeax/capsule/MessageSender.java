package net.ddns.thezeax.capsule;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void> {

    Socket socket;
    DataOutputStream dataOutputStream;
    //PrintWriter printWriter;

    @Override
    protected Void doInBackground(String... voids) {

        String message = voids[0];

        try {
            //socket = new Socket ("192.168.0.10", 3033);
            socket = new Socket ("192.168.232.2", 3033);
            /*printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write(message);
            printWriter.flush();
            printWriter.close();*/
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

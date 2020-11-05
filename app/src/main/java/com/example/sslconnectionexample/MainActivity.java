package com.example.sslconnectionexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doBasicAuth(View view) {
        new Connection().execute();
    }

    private class Connection extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            HttpEntity responseEntity = null;
            try {
                responseEntity = connect();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.e("MainActivity", "connectResponse:  " + responseEntity);

            return responseEntity;
        }

        @Override
        protected void onPostExecute(Object o) {
//            Log.e("MainActivity", "connectResponse:  " + o.toString());
            Intent intent = new Intent(MainActivity.this, SuccesTask.class);
//            intent.setClass(getApplicationContext(), SuccesTask.class);
            intent.putExtra("helloKey", "Success in connection");
            startActivity(intent);
        }
    }

    private HttpEntity connect() throws IOException {
// Instantiate the custom HttpClient
        DefaultHttpClient client = new MyHttpClient(this);
        HttpGet get = new HttpGet("https://www.google.com");
// Execute the GET call and obtain the response
        HttpResponse getResponse = client.execute(get);
        return getResponse.getEntity();
    }
}

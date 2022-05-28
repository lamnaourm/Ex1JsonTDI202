package com.example.ex1jsontdi202;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = findViewById(R.id.tres);

        try {
            String json = LoadJsonFromRaw(R.raw.personne);

            JSONObject obj = new JSONObject(json);

            t.setText("Nom : " + obj.getString("nom") + "\n" + "Prenom : " + obj.getString("prenom") + "\n"+ "Age : " + obj.getInt("age"));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }


    public String LoadJsonFromRaw(int resId) throws IOException {
        String res = "";

        int taille = 0;
        InputStream input = getResources().openRawResource(resId);
        taille = input.available();
        byte[] data = new byte[taille];
        input.read(data);
        input.close();
        res = new String(data);

        return res;
    }
}
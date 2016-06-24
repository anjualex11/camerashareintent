package com.example.reboot.shareintent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void capture(View view) {
      /*  EditText edit=(EditText)findViewById(R.id.editText);
        String send=edit.getText().toString();
        Intent shareIntent=new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,send);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);

        String url="https://web.whatsapp.com/";
        Intent browserIntent=new Intent();
        browserIntent.setAction(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url));
        startActivity(browserIntent);


       Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);   */


        Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,4567);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        Bitmap capturedbitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(capturedbitmap);
        Toast.makeText(this,requestCode+"",Toast.LENGTH_LONG).show();
    }
}

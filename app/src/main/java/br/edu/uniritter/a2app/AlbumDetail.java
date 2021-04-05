package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.a2app.model.Album;

public class AlbumDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);
        Intent intent = getIntent();
        Album album = intent.getParcelableExtra("albumObj");
        sendAlbum(album);
    }

    private void sendAlbum(Album a) {
        TextView userId = findViewById(R.id.albumUserId);
        userId.setText("User ID: "+a.getUserId());
        TextView id = findViewById(R.id.albumId);
        id.setText("ID: "+a.getId());
        TextView title = findViewById(R.id.albumTitle);
        title.setText(a.getTitle());
    }
}
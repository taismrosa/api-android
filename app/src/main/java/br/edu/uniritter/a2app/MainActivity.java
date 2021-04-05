package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Posts
        Button postsBtn = (Button) findViewById(R.id.postsButton);
        postsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postsInt = new Intent(v.getContext(), Posts.class);
                startActivity(postsInt);
            }
        });

        // Comments
        Button commentsBtn = (Button) findViewById(R.id.commentsButton);
        commentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commentsInt = new Intent(v.getContext(), Comments.class);
                startActivity(commentsInt);
            }
        });

        // Albums
        Button albumsBtn = (Button) findViewById(R.id.albumsButton);
        albumsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsInt = new Intent(v.getContext(), Albums.class);
                startActivity(albumsInt);
            }
        });

        // Todos
        Button todosBtn = (Button) findViewById(R.id.todosButton);
        todosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent todosInt = new Intent(v.getContext(), Todos.class);
                startActivity(todosInt);
            }
        });
    }
}
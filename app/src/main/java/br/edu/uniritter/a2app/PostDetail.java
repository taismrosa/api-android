package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.a2app.model.Post;

public class PostDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);
        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("postObj");
        sendPost(post);
    }

    private void sendPost(Post p) {
        TextView userId = findViewById(R.id.postUserId);
        userId.setText("User ID: "+p.getUserId());
        TextView id = findViewById(R.id.postId);
        id.setText("ID: "+p.getId());
        TextView title = findViewById(R.id.postTitle);
        title.setText(p.getTitle());
        TextView body = findViewById(R.id.postBody);
        body.setText(p.getBody());
    }
}
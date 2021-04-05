package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.a2app.model.Comment;

public class CommentDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_detail);
        Intent intent = getIntent();
        Comment comment = intent.getParcelableExtra("commentObj");
        sendComment(comment);
    }

    private void sendComment(Comment c) {
        TextView postId = findViewById(R.id.commentPostId);
        postId.setText("Post: "+c.getPostId());
        TextView id = findViewById(R.id.commentId);
        id.setText("ID: "+c.getId());
        TextView title = findViewById(R.id.commentName);
        title.setText(c.getName());
        TextView email = findViewById(R.id.commentEmail);
        email.setText(c.getEmail());
        TextView body = findViewById(R.id.commentBody);
        body.setText(c.getBody());
    }
}
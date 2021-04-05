package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.a2app.model.Todo;

public class TodoDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("todoObj");
        sendTodo(todo);
    }

    private void sendTodo(Todo t) {
        TextView userId = findViewById(R.id.todoUserId);
        userId.setText("User ID: "+t.getUserId());
        TextView id = findViewById(R.id.todoId);
        id.setText("ID: "+t.getId());
        TextView title = findViewById(R.id.todoTitle);
        title.setText(t.getTitle());
        TextView completed = findViewById(R.id.todoCompleted);
        completed.setText(t.isCompleted() ? "true" : "false");
    }
}
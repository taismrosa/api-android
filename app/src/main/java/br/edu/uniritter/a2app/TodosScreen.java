package br.edu.uniritter.a2app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.a2app.model.Album;
import br.edu.uniritter.a2app.model.Todo;

public class TodosScreen extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    List<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos_screen);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/todos";
        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url, null, this, this);
        queue.add(jsonRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"ERRO: "+msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                Todo obj = new Todo(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed")
                );
                todos.add(obj);
            }
            LinearLayout ll = findViewById(R.id.llTodos);
            for(Todo obj1 : todos) {
                Button bt = new Button(this);
                bt.setText(obj1.getTitle());
                bt.setTag(obj1);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Button btn = (Button) view;
                        Todo todo = (Todo) btn.getTag();
                        Intent intent = new Intent(getApplicationContext(), TodoDetail.class);
                        intent.putExtra("todoObj", todo);
                        startActivity(intent);
                    }
                });
                ll.addView(bt);
            }
        }
        catch (JSONException e) {
            Log.e("ERRO ",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
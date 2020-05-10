package com.example.soultosoul.MarfaQ.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soultosoul.MarfaQ.Adapter.BlogAdapter;
import com.example.soultosoul.MarfaQ.Entities.Blog;
import com.example.soultosoul.MarfaQ.Network.NetworkService;
import com.example.soultosoul.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadActivity extends AppCompatActivity {
    static List<Blog> blog = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        final TextView titleRead = findViewById(R.id.titleRead);
        final TextView mainRead = findViewById(R.id.mainRead);
        final TextView authorRead = findViewById(R.id.authorRead);

        Bundle arguments = getIntent().getExtras();
        Blog blogValue;
        if(arguments!=null){
            blogValue = (Blog) arguments.getSerializable(Blog.class.getSimpleName());
            titleRead.setText(blogValue.getTitle());
            mainRead.setText(blogValue.getContent());
            //authorRead.setText(blogValue.getUser_id());

//            textView.setText("Name: " + product.getName() + "\nCompany: " + product.getCompany() +
//                    "\nPrice: " + String.valueOf(product.getPrice()));
            getOtherBlog(blogValue);
        }

        RecyclerView recyclerView = findViewById(R.id.listRec);
        // создаем адаптер
        BlogAdapter adapter = new BlogAdapter(this, blog);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }


    private void getOtherBlog(Blog blogValue) {
        NetworkService.getInstance()
                .getJSONApi().getAllBlogs().enqueue(new Callback<List<Blog>> (){
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                blog = response.body();
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                System.out.println("Error occurred while getting request! #12");
                t.printStackTrace();
            }
        });
    }
}

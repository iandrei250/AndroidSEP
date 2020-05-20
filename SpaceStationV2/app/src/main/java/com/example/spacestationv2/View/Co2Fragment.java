package com.example.spacestationv2.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spacestationv2.Model.Api;
import com.example.spacestationv2.R;
import com.example.spacestationv2.ViewModel.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Co2Fragment extends Fragment {

    private View rootView;
    private TextView view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retro = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        rootView = inflater.inflate(R.layout.fragment_co2, container, false);

        view = (TextView)rootView.findViewById(R.id.retrofit_fragmentco2);
        Api api = retro.create(Api.class);
        Call<List<Post>> call = api.getPosts();

    call.enqueue(new Callback<List<Post>>() {
    @Override
    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

        if(!response.isSuccessful())
        {
            view.setText("Code: " + response.code());
            return;
        }

        List<Post> posts = response.body();

        for(Post post : posts )
        {
            String content = "";
            content+= "ID: " + post.getId() + "\n";
            content+="UserId: " + post.getUserId() + "\n";
            content+="Title: " + post.getText() + "\n\n";

            view.append(content);

        }
    }

    @Override
    public void onFailure(Call<List<Post>> call, Throwable t) {

        view.setText(t.getMessage());
    }
});

        return rootView;

    }


}

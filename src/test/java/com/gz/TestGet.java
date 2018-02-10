package com.gz;

import com.gz.dto.Repo;
import com.gz.dto.User;
import com.gz.service.GitHubService;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author xiaozefeng
 */
public class TestGet {

    @Test
    public void testGetRepos() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<List<Repo>> octocat = gitHubService.listRepos("xiaozefeng");
        Response<List<Repo>> execute = octocat.execute();
        List<Repo> body = execute.body();
        body.forEach(System.out::println);
    }

    @Test
    public void testGetUser() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<User> call = gitHubService.getUser("xiaozefeng");
        User user = call.execute().body();
        System.out.println(user);

    }
}

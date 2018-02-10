package com.gz.service;

import com.gz.dto.Repo;
import com.gz.dto.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

/**
 * @author xiaozefeng
 */
public interface GitHubService {
    /**
     * 仓库列表
     * @param user
     * @return
     */
    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

    /**
     * 用户信息
     * @param user
     * @return
     */
    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);
}

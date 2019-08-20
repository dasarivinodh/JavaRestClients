package com.rest.client.Interface;

public interface GitHubService {
	@GET("users/{user}/repos")
	Call<List<Repo>> listRepos(@Path("user") String user);

	@GET("group/{id}/users")
	Call<List<User>> groupList(@Path("id") int groupId);
}
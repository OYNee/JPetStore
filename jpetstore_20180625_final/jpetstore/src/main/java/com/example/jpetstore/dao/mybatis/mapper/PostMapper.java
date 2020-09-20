package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.example.jpetstore.domain.Post;

public interface PostMapper {
	List<Post> getReviewByUsername(String username);
	int insert(Post post);
	List<Post> selectPage(Map<String,Object> param);
	int countAll();
	Post selectByPostId(int postid);
	void updateHitcount(Map<String,Object> param);
	void delete(int postid);
	void update(Post post);
	Post updateLikecount(Map<String,Object> param);
}

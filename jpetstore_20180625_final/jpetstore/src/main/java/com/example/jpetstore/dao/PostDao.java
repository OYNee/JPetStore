package com.example.jpetstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Post;

public interface PostDao {
	List<Post> getReviewByUsername(String username) throws DataAccessException;
	int insert(Post post);
	List<Post> selectPage(int pageNo, int rowsPerPage);
	int countAll();
	Post selectByPostId(int postid);
	void updateHitcount(int postid, String loginID, int view_count);
	void delete(int postid);
	void update(Post post);
	void updateLikecount(int postid, String loginID, int like_count);
}

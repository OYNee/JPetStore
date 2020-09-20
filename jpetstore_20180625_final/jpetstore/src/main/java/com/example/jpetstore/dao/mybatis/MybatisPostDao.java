package com.example.jpetstore.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.PostDao;
import com.example.jpetstore.dao.mybatis.mapper.PostMapper;
import com.example.jpetstore.domain.Letter;
import com.example.jpetstore.domain.Post;

@Repository
public class MybatisPostDao implements PostDao{
	
	@Autowired
	private PostMapper postMapper;

	public List<Post> getReviewByUsername(String username) throws DataAccessException{
		return postMapper.getReviewByUsername(username);
	}

	@Override
	public int insert(Post post) {
		postMapper.insert(post);
		int postid=post.getPostid();
		return postid;
	}

	@Override
	public List<Post> selectPage(int pageNo, int rowsPerPage) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("endNum", pageNo * rowsPerPage);
		map.put("startNum", (pageNo - 1) * rowsPerPage);
		List<Post> postList = postMapper.selectPage(map);
		return postList;
	}

	@Override
	public int countAll() {
		return postMapper.countAll();
	}

	@Override
	public Post selectByPostId(int postid) {
		return postMapper.selectByPostId(postid);
	}

	@Override
	public void updateHitcount(int postid, String loginID, int view_count) {
		Map<String, Object> map = new HashMap<>();
		map.put("postid", postid);
		map.put("loginID", loginID);
		map.put("view_count", view_count + 1);
		
		postMapper.updateHitcount(map);
		
	}

	@Override
	public void delete(int postid) {
		postMapper.delete(postid);
		
	}

	@Override
	public void update(Post post) {
	postMapper.update(post);
		
	}

	@Override
	public void updateLikecount(int postid, String loginID, int like_count) {
		Map<String, Object> map = new HashMap<>();
		map.put("postid", postid);
		map.put("loginID", loginID);
		map.put("like_count", like_count + 1);
		postMapper.updateLikecount(map);
		
	}
	
	
}

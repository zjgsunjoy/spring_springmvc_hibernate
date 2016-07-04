package com.sunjoy.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sunjoy.model.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
	
	// 修改博文操作
	@Modifying
	@Transactional
	@Query("update BlogEntity blog set blog.title=:qTitle, blog.userByUserId.id=:qUserId," +
	        " blog.content=:qContent, blog.pubDate=:qPubDate where blog.id=:qId")
	void updateBlog(@Param("qTitle") String title, @Param("qUserId") Long userId, @Param("qContent") String content,
	                @Param("qPubDate") Date pubDate, @Param("qId") Long id);
}

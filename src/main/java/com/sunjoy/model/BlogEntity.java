package com.sunjoy.model;


import java.sql.Date;

import javax.persistence.*;




@Entity
@Table(name = "blog", schema = "springdemo", catalog = "")
public class BlogEntity {
	private long id;
	private String title;
	private String content;
	private Date pubDate;
	private UserEntity userByUserId;

	@Id
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Basic
	@Column(name = "content", nullable = false, length = 255)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Basic
	@Column(name = "pub_date", nullable = false)
	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName="id",nullable=false)
	public UserEntity getUserByUserId() {
		return userByUserId;
	}

	public void setUserByUserId(UserEntity userByUserId) {
		this.userByUserId = userByUserId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BlogEntity that = (BlogEntity) o;
		if (id != that.id)
			return false;
		if (title != null ? !title.equals(that.title) : that.title != null)
			return false;
		if (content != null ? !content.equals(that.content) : that.content != null)
			return false;
		if (pubDate != null ? !pubDate.equals(that.pubDate) : that.pubDate != null)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlogEntity [id=" + id + ", title=" + title + ", content=" + content + ", pubDate=" + pubDate
				+ ", userByUserId=" + userByUserId + "]";
	}
	
}

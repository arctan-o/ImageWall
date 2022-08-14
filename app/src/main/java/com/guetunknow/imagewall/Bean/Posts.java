package com.guetunknow.imagewall.Bean;

public class Posts {
    String uid;	//	用户标识符，标记帖子属于哪一个用户
    String post_id;		//帖子id，一个用户会有多个帖子,用于区分，数据库生成
    String user_name;	//用户名，直接从（user）读取
    String title;		//	帖子标题
    String description;	//帖子内容
    int	thumbs_up;		//点赞数

    public Posts(String uid, String post_id, String user_name, String title, String description, int thumbs_up) {
        this.uid = uid;
        this.post_id = post_id;
        this.user_name = user_name;
        this.title = title;
        this.description = description;
        this.thumbs_up = thumbs_up;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(int thumbs_up) {
        this.thumbs_up = thumbs_up;
    }
}

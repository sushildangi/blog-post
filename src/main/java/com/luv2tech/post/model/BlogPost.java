package com.luv2tech.post.model;


import com.luv2tech.model.User;
import com.luv2tech.model.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "blog_post")
@Setter
@Getter
@ToString
public class BlogPost extends BaseAudit<String> {
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;
}

package com.tensquare.article.dao;

import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *文章
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
	//根据id修改文章审核
    @Modifying
    @Query(value = "update tb_article set state='1' where id=?1",nativeQuery = true)
    public void examine(String id);

    //修改点赞数
    @Modifying
    @Query(value = "update tb_article set  thumbup=thumbup+1 where id=?1",nativeQuery = true)
    public void addthumbup(String id);
}

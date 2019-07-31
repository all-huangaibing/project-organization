package com.hab.project.esdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
/**
 * 功能：
 *
 * @author huangaibing
 * @date  2019/7/31 14:24
 */
@Data
@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
public class Item {
	
	/**
	 * @Description: @Id注解必须是springframework包下的
	 * org.springframework.data.annotation.Id
	 */
    @Id
    private Long id;
    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    
    @Field(type = FieldType.Keyword)
    private String category;
    
    @Field(type = FieldType.Keyword)
    private String brand;
    
    @Field(type = FieldType.Double)
    private Double price;
    
    @Field(index = false, type = FieldType.Keyword)
    private String images;
}

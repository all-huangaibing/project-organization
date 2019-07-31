package com.hab.project.esdemo.controller;

import com.hab.project.esdemo.model.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能：
 *
 * @author huangaibing
 * @date  2019/7/31 14:18
 */
@Slf4j
@RestController
public class EsController {
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/test")
    public boolean test(){
//        boolean index = elasticsearchTemplate.createIndex(Item.class);
         boolean index = true;
        log.info("createIndex result : {}",index);
        return index;
    }

}

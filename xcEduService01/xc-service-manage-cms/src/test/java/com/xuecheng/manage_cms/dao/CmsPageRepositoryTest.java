package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Test
    public void test(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);

    }
    @Test
    public void testFindPage(){
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(pageable);
        List<CmsPage> content =cmsPages.getContent();
        System.out.println(content);
    }

    @Test
    public void testFindAllByExample(){
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page,size);
        //存放查询条件的对象
        CmsPage cmsPage=new CmsPage();
        //查询站点信息为如下页面
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        //条件匹配器
        ExampleMatcher exampleMatcher=ExampleMatcher.matching();
        //定义Examle
        Example<CmsPage> example=Example.of(cmsPage,exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example,pageable);
        List<CmsPage> content =cmsPages.getContent();
        System.out.println(cmsPages);
        System.out.println("============");
        System.out.println(content);
    }
    @Test
    public void testFindAllIndistinct(){
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page,size);
        //存放查询条件的对象
        CmsPage cmsPage=new CmsPage();
        //查询别名信息为如下(模糊查询)
        cmsPage.setPageAliase("轮播");
        //条件匹配器
        ExampleMatcher exampleMatcher=ExampleMatcher.matching();
        //设置模糊查询
         exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //定义Examle
        Example<CmsPage> example=Example.of(cmsPage,exampleMatcher);
        Page<CmsPage> cmsPages = cmsPageRepository.findAll(example,pageable);
        List<CmsPage> content =cmsPages.getContent();
        System.out.println(cmsPages);
        System.out.println("============");
        System.out.println(content);
    }
    @Test
    public void testAdd(){
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试页面");
        cmsPage.setTemplateId("testAdd");
        cmsPage.setPageAliase("t1");
        cmsPage.setPageCreateTime(new Date());
        cmsPage.setSiteId("t01");
        List<CmsPageParam> cmsPages = new ArrayList<>();
        cmsPage.setPageParams(cmsPages);
        cmsPageRepository.save(cmsPage);
    }
    @Test
    public void testDele(){
        cmsPageRepository.deleteById("5efddd3881134a26f4378b3e");
    }

    @Test
    public void testUpdate(){
        Optional<CmsPage> optional = cmsPageRepository.findById("5efddd3881134a26f4378b3e");
        if (optional.isPresent()){
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("测试修改");
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }

    }
    @Test
    public void testFindByPageName(){
        CmsPage cmsPage = cmsPageRepository.findByPageName("index.html");
        System.out.println(cmsPage);
    }


}

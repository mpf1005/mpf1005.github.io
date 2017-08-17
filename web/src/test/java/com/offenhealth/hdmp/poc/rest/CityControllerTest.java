//package com.offenhealth.hdmp.poc.rest;
//
//import com.github.pagehelper.PageInfo;
//import com.offenhealth.hdmp.Application;
//import ResultCode;
//import ResultResponse;
//import Sequence;
//import City;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by Administrator on 2017/7/18.
// */
//@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
//@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
//@FixMethodOrder(MethodSorters.JVM)
//public class CityControllerTest {
//
//    @Autowired
//    CityController cityController;
//
//
//    @Test
//    public void testPageList() throws Exception {
//
//        Sequence sequence = new Sequence(1,1);
//
//        sequence.nextId();
//
//        ResultResponse result = cityController.pageList(1, 10, "search");
//        Assert.assertTrue(((PageInfo) result.getData()).getSize()>0);
//    }
//
//    @Test
//    public void testSave() throws Exception {
//        City city = new City();
//        ResultResponse result = cityController.save(city);
//        Assert.assertEquals(ResultCode.SUCCESS_CODE.getCode(), result.getCode().intValue());
//    }
//
//    @Test
//    public void testInfo() throws Exception {
//        ResultResponse result = cityController.info("0b1d7d986dc211e7b1b7fcaa14d5b680");
//        Assert.assertEquals("0b1d7d986dc211e7b1b7fcaa14d5b680", ((City)  result.getData()).getId());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//        ResultResponse result = cityController.info("0b1d7d986dc211e7b1b7fcaa14d5b680");
//        City city = (City) result.getData();
//        city.setName("hhy");
//        result = cityController.update(city);
//        Assert.assertEquals(ResultCode.SUCCESS_CODE.getCode(), result.getCode().intValue());
//    }
//
//    @Test
//    public void testDeleteBatch() throws Exception {
//     //   ResultResponse result = cityController.deleteBatch(new Long[]{1L});
//     //   Assert.assertEquals(ResultCode.SUCCESS_CODE.getCode(), result.getCode().intValue());
//    }
//}
//
////Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
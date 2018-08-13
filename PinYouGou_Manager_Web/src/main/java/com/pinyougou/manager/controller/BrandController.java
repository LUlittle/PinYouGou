package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: PinYouGou_Parent
 * @description:
 * @author: LLL
 * @create: 2018-08-12 20:11
 **/
@RestController //该类中每个方法都带有@ResponseBody
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        List<TbBrand> list = brandService.findAll();
        return list;
    }
}

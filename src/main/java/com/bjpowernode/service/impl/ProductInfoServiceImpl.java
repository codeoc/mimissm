package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.ProductInfoExample;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    //在业务逻辑层中，一定会有数据访问层对象
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }


    //select * from puduct_info limit 起始页记录数=（当前页-1）*每一页条数），每一页取几条
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        //进行PageInfo的数据封装
        //进行有条件查询操作
        ProductInfoExample example =new ProductInfoExample();
        //设置排序，按主键降序排序。
        example.setOrderByClause("p_id desc");
        //设置完排序后，取集合，切记：一定在取集合之前，设置pageHelper  PageHelper.startPage(pageNum,pageSize);
        List<ProductInfo> list =productInfoMapper.selectByExample(example);
        //将查询到的集合封装进PageInfo对象中
        PageInfo<ProductInfo> pageInfo =new PageInfo<>(list);

        return pageInfo;
    }
}

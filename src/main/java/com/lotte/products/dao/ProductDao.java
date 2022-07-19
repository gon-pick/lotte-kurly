package com.lotte.products.dao;

import com.lotte.products.dto.ProductDto;
import com.lotte.products.dto.ProductListDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ProductDao {
    List<ProductListDto> productList(String category);
    List<ProductListDto>productLowList();
    List<ProductListDto>productHighList();
    void insertProducts(ProductDto product);
    void updateProducts(ProductDto product);
}

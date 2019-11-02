package com.baomidou.springmvc.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.springmvc.dto.SalesDto;
import com.baomidou.springmvc.model.PrivateStation;
import com.baomidou.springmvc.model.Sales;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
public interface SalesMapper extends BaseMapper<Sales> {


    int insetSales(Sales sales) throws Exception;
    int updateSales(Sales sales) throws Exception;
    Sales getSalseById(String id) throws Exception;
    List<Sales> getAllSales(Pagination page,Wrapper<Sales> wrapper) throws Exception;
    List<Sales> getAllDerectSales(Pagination page,Wrapper<Sales> wrapper) throws Exception;
    List<Sales> getAllDistributionSales(Pagination page, Wrapper<Sales> wrapper) throws Exception;
    List<Sales> getAllOwnershipSales(Pagination page,Wrapper<Sales> wrapper) throws Exception;
    List<PrivateStation> getAllPrivateStationSales(Pagination page, Map<String, Object> condition) throws Exception;
    List<PrivateStation> getAllPrivateStationSalesWithArea(Pagination page,@Param("ew") Wrapper<PrivateStation> wrapper) throws Exception;

    List<SalesDto> getAllPrivateStationSalesWithAreaAndSum(Pagination page, @Param("ew") Wrapper<SalesDto> wrapper) throws Exception;

    List<SalesDto> getAllPrivateStationSalesWithAreaAndSumByStaion(Pagination page, @Param("ew") Wrapper<SalesDto> wrapper) throws Exception;














}
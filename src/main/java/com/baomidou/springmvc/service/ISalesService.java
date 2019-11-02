package com.baomidou.springmvc.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springmvc.dto.SalesDto;
import com.baomidou.springmvc.model.PrivateStation;
import com.baomidou.springmvc.model.Sales;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;


import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
public interface ISalesService extends IService<Sales> {


    int insetSales(Sales sales) throws Exception;
    int updateSales(Sales sales) throws Exception;
    Sales getSalseById(String id) throws Exception;
    Page<Sales> getAllSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception;
    Page<Sales> getAllDerectSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception;
    Page<Sales> getAllDistributionSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception;
    Page<Sales> getAllOwnershipSales(Page<Sales> page,Wrapper<Sales> wrapper) throws Exception;
    Page<PrivateStation> getAllPrivateStationSalse(Page<PrivateStation> page, Map<String,Object> condition) throws Exception;
    Page<PrivateStation> getAllPrivateStationSalseWithArea(Page<PrivateStation> page, @Param("ew") Wrapper<PrivateStation> wrapper) throws Exception;

    Page<SalesDto> getAllPrivateStationSalseWithAreaAndSum(Page<SalesDto> page, @Param("ew") Wrapper<SalesDto> wrapper) throws Exception;


    Page<SalesDto> getAllPrivateStationSalseWithAreaAndSumByStation(Page<SalesDto> page, @Param("ew") Wrapper<SalesDto> wrapper) throws Exception;




}

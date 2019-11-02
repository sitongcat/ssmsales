package com.baomidou.springmvc.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springmvc.dto.SalesDto;
import com.baomidou.springmvc.model.PrivateStation;
import com.baomidou.springmvc.model.Sales;
import com.baomidou.springmvc.mapper.SalesMapper;
import com.baomidou.springmvc.service.ISalesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
@Service("SalesService")
public class SalesServiceImpl extends ServiceImpl<SalesMapper, Sales> implements ISalesService {


    @Autowired
    private SalesMapper salesMapper;


    @Override
    public Sales getSalseById(String id) throws Exception {
        return salesMapper.selectById(id);
    }

    @Override
    public Page<Sales> getAllSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception {
        page.setRecords(salesMapper.selectPage(page,null));
        return page;
    }

    @Override
    public Page<Sales> getAllDerectSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception {
        page.setRecords(salesMapper.selectPage(page,wrapper));
        return page;
    }

    @Override
    public Page<Sales> getAllDistributionSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception {
        page.setRecords(salesMapper.selectPage(page,wrapper.eq("sales_channel","分销")));
        return null;
    }

    @Override
    public Page<Sales> getAllOwnershipSales(Page<Sales> page, Wrapper<Sales> wrapper) throws Exception {
        page.setRecords(salesMapper.selectPage(page,wrapper.eq("sales_channel","分销")
                        .isNotNull("sales_station")));
        return page;
    }

    @Override
    public Page<PrivateStation> getAllPrivateStationSalse(Page<PrivateStation> page, Map<String,Object> condition) throws Exception {

        List<PrivateStation> allPrivateStationSales = salesMapper.getAllPrivateStationSales(page,condition);
        page.setRecords(allPrivateStationSales);
        return page;
    }

    @Override
    public Page<PrivateStation> getAllPrivateStationSalseWithArea(Page<PrivateStation> page, Wrapper<PrivateStation> wrapper) throws Exception {

        List<PrivateStation> allPrivateStationSalesWithArea = salesMapper.getAllPrivateStationSalesWithArea(page, wrapper);
        page.setRecords(allPrivateStationSalesWithArea);
        return page;
    }

    @Override
    public Page<SalesDto> getAllPrivateStationSalseWithAreaAndSum(Page<SalesDto> page, Wrapper<SalesDto> wrapper) throws Exception {

        List<SalesDto> allPrivateStationSalesWithAreaAndSum = salesMapper.getAllPrivateStationSalesWithAreaAndSum(page, wrapper);
        page.setRecords(allPrivateStationSalesWithAreaAndSum);
        return page;
    }

    @Override
    public Page<SalesDto> getAllPrivateStationSalseWithAreaAndSumByStation(Page<SalesDto> page, Wrapper<SalesDto> wrapper) throws Exception {
        List<SalesDto> allPrivateStationSalesWithAreaAndSumByStaion = salesMapper.getAllPrivateStationSalesWithAreaAndSumByStaion(page, wrapper);
       page.setRecords(allPrivateStationSalesWithAreaAndSumByStaion);
        return page;
    }


    @Override
    public int insetSales(Sales sales) throws Exception {
        return salesMapper.insetSales(sales);
    }

    @Override
    public int updateSales(Sales sales) throws Exception {
        return salesMapper.updateSales(sales);
    }
}

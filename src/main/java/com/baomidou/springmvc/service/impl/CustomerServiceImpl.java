package com.baomidou.springmvc.service.impl;

import com.baomidou.springmvc.model.Customer;
import com.baomidou.springmvc.mapper.CustomerMapper;
import com.baomidou.springmvc.service.ICustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {
	
}

package com.baomidou.springmvc.service.impl;

import com.baomidou.springmvc.model.Manager;
import com.baomidou.springmvc.mapper.ManagerMapper;
import com.baomidou.springmvc.service.IManagerService;
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
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
	
}

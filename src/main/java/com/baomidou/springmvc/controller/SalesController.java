package com.baomidou.springmvc.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springmvc.dto.SalesDto;
import com.baomidou.springmvc.model.PrivateStation;
import com.baomidou.springmvc.model.Sales;
import com.baomidou.springmvc.service.ISalesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
@Controller
@RequestMapping("/sales")
public class SalesController extends BaseController {


    @Resource
    private ISalesService salesService;

//    private ISalesService salesService;

/*    @Autowired
    public SalesController( ISalesService salesService) {
        this.salesService = salesService;
    }*/


    @RequestMapping("/derectSales")
    public ModelAndView index(HttpServletRequest request, ModelAndView modelAndView, Page<Sales> page) throws Exception {
        if ((request.getParameter("current")==null) && (request.getParameter("pageSize")==null)) {
            page.setCurrent(1);
            page.setSize(5);
        }else {
            int current = Integer.parseInt(request.getParameter("current"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            page.setCurrent(current);
            page.setSize(pageSize);
        }
        salesService.getAllDerectSales(page, new EntityWrapper<Sales>().
                               eq("sales_channel","直销")
                               .or().eq("sales_channel","分销"));  //S5+S8销售明细
        modelAndView.setViewName("sales/derectSales");
        // modelAndView.addObject("userList", userService.selectList(null));
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @RequestMapping("/salesArea")
    public ModelAndView sales(HttpServletRequest request, ModelAndView modelAndView, Page<PrivateStation> page) throws Exception {
        if ((request.getParameter("current")==null) && (request.getParameter("pageSize")==null)) {
            page.setCurrent(1);
            page.setSize(10);
        }else {
            int current = Integer.parseInt(request.getParameter("current"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            page.setCurrent(current);
            page.setSize(pageSize);
        }

        salesService.getAllPrivateStationSalseWithArea(page,new EntityWrapper<PrivateStation>()
                                .between("sales_date","2019-01-01","2019-02-28")
        );
        //区域内分销明细


        modelAndView.setViewName("index");
        // modelAndView.addObject("userList", userService.selectList(null));
        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @RequestMapping("/privateSales")
    public ModelAndView privateSales(HttpServletRequest request, ModelAndView modelAndView, Page<SalesDto> page) throws Exception {
        if ((request.getParameter("current")==null) && (request.getParameter("pageSize")==null)) {
            page.setCurrent(1);
            page.setSize(10);
        }else {
            int current = Integer.parseInt(request.getParameter("current"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            page.setCurrent(current);
            page.setSize(pageSize);
        }

        salesService.getAllPrivateStationSalseWithAreaAndSum(page,new EntityWrapper<SalesDto>()
                .between("sales_date","2019-01-01","2019-02-28")
        );
        //区域内分销明细

        /*salesService.getAllPrivateStationSalseWithAreaAndSumByStation(page,new EntityWrapper<SalesDto>()
                        .between("sales_date","2019-01-01","2019-02-28"));*/
        modelAndView.setViewName("sales/privateSales");
        modelAndView.addObject("page", page);
        // modelAndView.addObject("userList", userService.selectList(null));
        // modelAndView.addObject("page", page);
        //modelAndView.addObject("psPage",page);
        return modelAndView;
    }













}

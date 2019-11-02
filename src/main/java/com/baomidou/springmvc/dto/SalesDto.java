package com.baomidou.springmvc.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SalesDto {

    private String id;
    private Date sales_date;
    private String customer_id;
    private String customer_name;
    private String sales_oil;
    private Double sales_price;
    private Double sales_count;
    private String customer_area;
    private double sumgas;
    private double sumdiesel;
    private double heji;

}

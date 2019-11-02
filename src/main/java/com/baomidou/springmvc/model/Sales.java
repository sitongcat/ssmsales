package com.baomidou.springmvc.model;

import java.util.Date;
import java.io.Serializable;
import com.baomidou.mybatisplus.enums.FieldFill;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangfeng
 * @since 2019-03-25
 */
@Data
@Accessors(chain = true)
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * UUID主键
     */
	private String id;
    /**
     * 销售渠道
     */
	private String salesChannel;
    /**
     * 销售时间
     */
	private Date salesDate;
    /**
     * 客户编码
     */
	private String customerId;
    /**
     * 客户名称
     */
	private String customerName;
    /**
     * 销售油品
     */
	private String salesOil;
    /**
     * 客户经理编码
     */
	private String managerId;
    /**
     * 客户经理姓名
     */
	private String managerName;
    /**
     * 业务加油站
     */
	private String salesStation;
    /**
     * 销售数量
     */
	private Double salesCount;
    /**
     * 销售价格
     */
	private Double salesPrice;
    /**
     * 是否串渠道销售，默认填充0，该值为1则为转零售销售
     */
	private Integer isTransfer;


	@Override
	public String toString() {
		return "Sales{" +
			", id=" + id +
			", salesChannel=" + salesChannel +
			", salesDate=" + salesDate +
			", customerId=" + customerId +
			", customerName=" + customerName +
			", salesOil=" + salesOil +
			", managerId=" + managerId +
			", managerName=" + managerName +
			", salesStation=" + salesStation +
			", salesCount=" + salesCount +
			", salesPrice=" + salesPrice +
			", isTransfer=" + isTransfer +
			"}";
	}
}

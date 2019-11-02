package com.baomidou.springmvc.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String customerId;
	private String customerName;
	private String customerAddress;
	private String customerArea;
	private String customerManager;
	private String customerSalesChannel;
	private String customerLevel;
    /**
     * 1-商客 ，2-零售  3- 公共
     */
	private String customerDep;


	@Override
	public String toString() {
		return "Customer{" +
			", id=" + id +
			", customerId=" + customerId +
			", customerName=" + customerName +
			", customerAddress=" + customerAddress +
			", customerArea=" + customerArea +
			", customerManager=" + customerManager +
			", customerSalesChannel=" + customerSalesChannel +
			", customerLevel=" + customerLevel +
			", customerDep=" + customerDep +
			"}";
	}
}

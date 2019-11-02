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
public class PrivateStation implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String customerId;
	private String customerName;
	private Double customerDemandGas;
	private Double customerDemandDiesel;
	private Double customerPlanDiesel;
	private String customerArea;
	private String competitionStation;
	private String customerManager;
	private String memo;
	private String customerAddress;
	private String customerAtten;
	private String tel;


	@Override
	public String toString() {
		return "PrivateStation{" +
			", id=" + id +
			", customerId=" + customerId +
			", customerName=" + customerName +
			", customerDemandGas=" + customerDemandGas +
			", customerDemandDiesel=" + customerDemandDiesel +
			", customerPlanDiesel=" + customerPlanDiesel +
			", customerArea=" + customerArea +
			", competitionStation=" + competitionStation +
			", customerManager=" + customerManager +
			", memo=" + memo +
			", customerAddress=" + customerAddress +
			", customerAtten=" + customerAtten +
			", tel=" + tel +
			"}";
	}
}

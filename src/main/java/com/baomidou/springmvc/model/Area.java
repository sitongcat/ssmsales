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
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String areaId;
	private String areaName;


	@Override
	public String toString() {
		return "Area{" +
			", id=" + id +
			", areaId=" + areaId +
			", areaName=" + areaName +
			"}";
	}
}

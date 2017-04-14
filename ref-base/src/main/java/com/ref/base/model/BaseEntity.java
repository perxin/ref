package com.ref.base.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity extends AbstractPage implements Serializable {
	
	private static final long serialVersionUID = -5284494226304695232L;

	/**
	 * @Description  createDate
	 */
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	/**
	 * @Description createBy
	 */
    private Long createBy;

	/**
	 * @Description updateDate
	 */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

	/**
	 * @Description updateBy
	 */
    private Long updateBy;

	/**
	 * @Description deleted
	 */
    protected Boolean deleted;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * get primaryKey
	 * @return id
	 */
	public abstract Object getPrimaryKey();

}

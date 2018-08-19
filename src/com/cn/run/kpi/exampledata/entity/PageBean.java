package com.cn.run.kpi.exampledata.entity;

import java.io.Serializable;
/**
 * 
 * <p>
 * Description: 分页处理bean
 * </p>
 *
 * @author zcy
 * @version 1.0

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2016-12-2 上午11:15:54         zcy        1.0         To create
 * </p>
 *
 * @since 
 * @see
 */
public class PageBean implements Serializable{
	
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -8188397306339770309L;
	/**
	 * 每页显示记录数
	 */
	private Integer pageSize = 20;
	
	/**
	 * 当前页
	 */
	private Integer currentPage = 1;
	/**
	 * 总记录数
	 */
	private Integer total;
	private Integer limit=10;
	private Integer offset=0;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		if(total!=null){
			this.totalPage = (int) Math.ceil((float)total/pageSize);
		}
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
		this.totalPage = (int) Math.ceil((float)total/pageSize);
	}
	
	public Integer getStart() {
		return (this.currentPage-1)*pageSize;
	}
	public Integer getEnd() {
		return (this.currentPage)*pageSize;
	}
	public Integer getStartb() {
		return this.offset;
	}
	public Integer getEndb() {
		return this.offset + this.limit;
	}

}

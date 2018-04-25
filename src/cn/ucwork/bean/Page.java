package cn.ucwork.bean;

import java.util.List;

public class Page<T> {

	private Integer currentPage;
	private Integer totalPage;
	private Integer currentCount;
	private Integer totalCount;
	private List<T> obj = null;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getObj() {
		return obj;
	}
	public void setObj(List<T> obj) {
		this.obj = obj;
	} 
}

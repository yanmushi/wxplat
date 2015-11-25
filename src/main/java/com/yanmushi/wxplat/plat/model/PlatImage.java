/*
 * copyrity @ YanMushi 2015
 */
package com.yanmushi.wxplat.plat.model;

import java.util.Date;

/**
 * @author yan.mushi
 * @since 
 */
public class PlatImage {
	private Integer id;
	private String resFromKey;
	private String resFromName;
	private String resPath;
	private Date createTime;
	private int resStatus;
	private int mid;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the resFromKey
	 */
	public String getResFromKey() {
		return resFromKey;
	}
	/**
	 * @param resFromKey the resFromKey to set
	 */
	public void setResFromKey(String resFromKey) {
		this.resFromKey = resFromKey;
	}
	/**
	 * @return the resFromName
	 */
	public String getResFromName() {
		return resFromName;
	}
	/**
	 * @param resFromName the resFromName to set
	 */
	public void setResFromName(String resFromName) {
		this.resFromName = resFromName;
	}
	/**
	 * @return the resPath
	 */
	public String getResPath() {
		return resPath;
	}
	/**
	 * @param resPath the resPath to set
	 */
	public void setResPath(String resPath) {
		this.resPath = resPath;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the resStatus
	 */
	public int getResStatus() {
		return resStatus;
	}
	/**
	 * @param resStatus the resStatus to set
	 */
	public void setResStatus(int resStatus) {
		this.resStatus = resStatus;
	}
	/**
	 * @return the mid
	 */
	public int getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
}

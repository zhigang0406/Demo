// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Page.java

package cn.tyyhoa.util;

import java.util.List;

import javax.crypto.spec.OAEPParameterSpec;

import cn.tyyhoa.pojo.OaRlzybEmployee;
import cn.tyyhoa.pojo.OaRlzybItem;
import cn.tyyhoa.pojo.OaRlzybLeave;


public class Page{
	/**
	 * 总页面数
	 */
	private int PageSize;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int TotalPageCount;
	/**
	 * 当前页面
	 */
	private int currentPageNo;
	
	
	private List<OaRlzybEmployee> oaRlzybEmployeeList;
	private List<OaRlzybLeave> oaRlzybLeaveList;
	private List<OaRlzybItem> oaRlzybItem;
	private List<OaRlzybEmployee> oaRlzybShiyongqi;
	
	public List<OaRlzybEmployee> getOaRlzybShiyongqi() {
		return oaRlzybShiyongqi;
	}

	public List<OaRlzybEmployee> setOaRlzybShiyongqi(List<OaRlzybEmployee> oaRlzybShiyongqi) {
		return this.oaRlzybShiyongqi = oaRlzybShiyongqi;
	}

	public List<OaRlzybItem> getOaRlzybItem() {
		return oaRlzybItem;
	}

	public void setOaRlzybItem(List<OaRlzybItem> oaRlzybItem) {
		this.oaRlzybItem = oaRlzybItem;
	}


	public List<OaRlzybEmployee> getOaRlzybEmployeeList() {
		return oaRlzybEmployeeList;
	}

	public void setOaRlzybEmployeeList(List<OaRlzybEmployee> oaRlzybEmployeeList) {
		this.oaRlzybEmployeeList = oaRlzybEmployeeList;
	}

	public List<OaRlzybLeave> getOaRlzybLeaveList() {
		return oaRlzybLeaveList;
	}

	public void setOaRlzybLeaveList(List<OaRlzybLeave> oaRlzybLeaveList) {
		this.oaRlzybLeaveList = oaRlzybLeaveList;
	}

	public Page()
	{
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount()
	{
		return TotalPageCount=totalCount % PageSize == 0 ? totalCount / PageSize  : totalCount / PageSize + 1;
	}
	public int getCurrentPageNo()
	{
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo)
	{
		if (currentPageNo <= 0)
			currentPageNo = 1;
		else
		if (currentPageNo >= TotalPageCount)
			currentPageNo = TotalPageCount;
		this.currentPageNo = currentPageNo;
	}

	public int getCurrentPageIndex()
	{
		return currentPageNo;
	}

	public int getPageSize()
	{
		return PageSize;
	}

	public void setPageSize(int objectPageSize)
	{
		PageSize = objectPageSize;
	}
}

package com.zgg.web.pojo.vo;

import com.zgg.web.pojo.ZgUser;

public class ZgUserVo {
	private ZgUser zgUser;

	private int page;
	private int size;

	public ZgUser getZgUser() {
		return zgUser;
	}

	public void setZgUser(ZgUser zgUser) {
		this.zgUser = zgUser;
	}

	public ZgUserVo(ZgUser zgUser, int page, int size) {
		super();
		this.zgUser = zgUser;
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ZgUserVo() {
		super();
	}
	
}

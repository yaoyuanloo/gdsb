package com.fortunes.gtxt.dubbo;

import com.yinhai.dubbo.common.AbstractResult;

import java.util.List;

/**
 * 柜台系统返回结果类型
 * Created by cxd on 2016/10/18.
 */
public class GtxtListResult<T> extends AbstractResult {
    private static final long serialVersionUID = -7558178217678745397L;
    private int totalCounts;    //总数
    private int totalPage;      //总页数
    private int currentPage;    //返回当前页
    private int rows;           //返回分页大小
    private List<T> list;       //结果信息

    public GtxtListResult() {
    }

    public GtxtListResult(boolean bizSuccess, String errorCode, String message) {
        this.bizSuccess = bizSuccess;
        this.errorCode = errorCode;
        this.message = message;
    }

    public GtxtListResult(int totalCounts, int totalPage, int cuIrrentPage, int rows, List<T> list) {
        this.bizSuccess = true;
        this.errorCode = "0";
        this.message = "success";
        this.totalCounts = totalCounts;
        this.totalPage = totalPage;
        this.rows = rows;
        this.currentPage = cuIrrentPage;
        this.list = list;
    }

    public GtxtListResult(boolean bizSuccess, String errorCode, String message, int totalCounts, int totalPage, int currentPage, int rows, List<T> list) {
        this.bizSuccess = bizSuccess;
        this.errorCode = errorCode;
        this.message = message;
        this.totalCounts = totalCounts;
        this.totalPage = totalPage;
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

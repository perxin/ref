package com.ref.base.model;

import com.github.pagehelper.PageHelper;

import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 *
 * Created by perxin on 2017/4/11.
 */
public class AbstractPage<T extends AbstractPage> implements Serializable {

    private static final long serialVersionUID = -3685219581169507914L;

    /**
     * 页码，默认1
     */
    @QueryParam("pageNum")
    protected int pageNum = 1;

    /**
     * 每页数量， 默认10
     */
    @QueryParam("pageSize")
    protected int pageSize = 10;

    public T startPage() {
        PageHelper.startPage(pageNum, pageSize);
        return (T) this;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}

package com.festech.webapi.base.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MyPageInfo<T> {

    private int pageNum;

    private int pageSize;

    private int size;

    private int startRow;

    private int endRow;

    private int pages;

    private int prePage;

    private int nextPage;

    private boolean isFirstPage;

    private boolean isLastPage;

    private boolean hasPreviousPage;

    private boolean hasNextPage;

    protected long total;

    protected List<T> list;

}

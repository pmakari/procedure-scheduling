/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.domain.dto.response;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by Parviz on 10.05.2018.
 */
public class SimplePageResponse<T extends Object> implements Page<T> {

    private List<T> content;
    private int totalPages;
    private long totalElements;
    private int number;
    private int size;
    private int numberOfElements;
    private boolean hasContent;
    private boolean hasNext;
    private boolean hasPrevious;
    private boolean isFirst;
    private boolean isLast;

    public SimplePageResponse() {
    }

    public SimplePageResponse(List<T> content, long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }

    public SimplePageResponse(List<T> content, int totalPages, long totalElements, int number, int size, int numberOfElements,
            boolean hasContent, boolean hasNext, boolean hasPrevious, boolean isFirst, boolean isLast) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.number = number;
        this.size = size;
        this.numberOfElements = numberOfElements;
        this.hasContent = hasContent;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
        this.isFirst = isFirst;
        this.isLast = isLast;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    public <S> Page<S> map(Converter<? super T, ? extends S> converter) {
        return null;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public boolean hasContent() {
        return hasContent;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return isFirst;
    }

    @Override
    public boolean isLast() {
        return isLast;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public boolean hasPrevious() {
        return hasPrevious;
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.caresyntax.scheduling.domain.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * Created by Parviz on 10.05.2018.
 */
public class PageRequestDTO implements Serializable {

    @Min(0)
    @NotNull
    private Integer page = 0;
    @Min(1)
    @Max(40)
    @NotNull
    private Integer size = 30;

    public PageRequestDTO() {
    }

    public PageRequestDTO(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

}

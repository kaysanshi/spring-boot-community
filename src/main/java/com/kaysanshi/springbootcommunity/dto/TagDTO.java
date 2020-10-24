package com.kaysanshi.springbootcommunity.dto;

import java.util.List;

/**
 * @Author kay三石
 * @date:2019/10/7
 */
public class TagDTO {
    private String categoryName;
    private List<String> tags;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List <String> getTags() {
        return tags;
    }

    public void setTags(List <String> tags) {
        this.tags = tags;
    }
}

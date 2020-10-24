package com.kaysanshi.springbootcommunity.dto;

/**
 * @Author kay三石
 * @date:2019/10/8
 */
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;
    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}

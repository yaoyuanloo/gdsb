package com.fortunes.gtxt.dubbo;

        import java.io.Serializable;

/**
 * 业务系统码表
 */
public class BusiDict implements Serializable {
    private static final long serialVersionUID = -2294142808465129408L;
    private String value;	    // 数据值
    private String label;	    // 标签名
    private String type;	    // 类型
    private String description; // 描述
    private Integer sort;	    // 排序
    private String parentId;    //父Id

    public BusiDict() {
    }

    public BusiDict(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}

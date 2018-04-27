package com.accp.entity;

public class FinanceType {
    private int typeId;  // 类型id
    private int  parentId; // 父级类型id
    private String typeName;  // 类型名
    private int typeStatus; // 状态
    private int allocation; // 配置数值
    private int realityAllocation; // 实际数值



    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(int typeStatus) {
        this.typeStatus = typeStatus;
    }

    public int getAllocation() {
        return allocation;
    }

    public void setAllocation(int allocation) {
        this.allocation = allocation;
    }

    public int getRealityAllocation() {
        return realityAllocation;
    }

    public void setRealityAllocation(int realityAllocation) {
        this.realityAllocation = realityAllocation;
    }
}

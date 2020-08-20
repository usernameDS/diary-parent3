package com.kmu.manager.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Deng
 * @since 2020-07-25
 */
@TableName("inner_manager_role")
public class InnerManagerRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("manager_id")
    private Integer managerId;
    @TableField("role_id")
    private Integer roleId;


    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "InnerManagerRole{" +
        ", managerId=" + managerId +
        ", roleId=" + roleId +
        "}";
    }
}

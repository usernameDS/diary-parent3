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
@TableName("inner_role_auth")
public class InnerRoleAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    private Integer roleId;
    @TableField("auth_id")
    private Integer authId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return "InnerRoleAuth{" +
        ", roleId=" + roleId +
        ", authId=" + authId +
        "}";
    }
}

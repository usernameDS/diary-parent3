package com.kmu.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-17
 */
@TableName("t_manager")
public class Manager extends Model<Manager> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer id;
    @TableField("m_account")
    private String account;
    @TableField("m_password")
    private String password;
    @TableField("m_create_date")
    private Date createDate;
    @TableField("m_name")
    private String name;
    @TableField("m_email")
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Manager{" +
        ", id=" + id +
        ", account=" + account +
        ", password=" + password +
        ", createDate=" + createDate +
        ", name=" + name +
        ", email=" + email +
        "}";
    }
}

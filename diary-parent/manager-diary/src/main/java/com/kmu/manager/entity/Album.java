package com.kmu.manager.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-08-17
 */
@TableName("t_album")
public class Album extends Model<Album> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "a_id", type = IdType.AUTO)
    private Integer aId;
    /**
     * 相册名
     */
    @TableField("a_name")
    private String aName;
    /**
     * 相册描述
     */
    @TableField("a_describe")
    private String aDescribe;
    @TableField("a_create_date")
    private Date aCreateDate;

    @TableField("u_id")
    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaDescribe() {
        return aDescribe;
    }

    public void setaDescribe(String aDescribe) {
        this.aDescribe = aDescribe;
    }

    public Date getaCreateDate() {
        return aCreateDate;
    }

    public void setaCreateDate(Date aCreateDate) {
        this.aCreateDate = aCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.aId;
    }

    @Override
    public String toString() {
        return "Album{" +
        ", aId=" + aId +
        ", aName=" + aName +
        ", aDescribe=" + aDescribe +
        ", aCreateDate=" + aCreateDate +
        "}";
    }
}

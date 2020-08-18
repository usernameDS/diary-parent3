package com.kmu.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_photos")
public class Photos extends Model<Photos> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "p_id", type = IdType.AUTO)
    private Integer pId;

    @TableField("a_id")
    private Integer aId;
    @TableField("p_name")
    private String pName;
    @TableField("p_create_date")
    private Date pCreateDate;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }



    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getpCreateDate() {
        return pCreateDate;
    }

    public void setpCreateDate(Date pCreateDate) {
        this.pCreateDate = pCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.pId;
    }

    @Override
    public String toString() {
        return "Photos{" +
        ", pId=" + pId +

        ", aId=" + aId +
        ", pName=" + pName +
        ", pCreateDate=" + pCreateDate +
        "}";
    }
}

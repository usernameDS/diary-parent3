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
@TableName("t_diary")
public class Diary extends Model<Diary> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;
    @TableField("u_id")
    private Integer uId;
    /**
     * 日记内容
     */
    @TableField("d_content")
    private String dContent;
    @TableField("d_create_date")
    private Date dCreateDate;


    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getdContent() {
        return dContent;
    }

    public void setdContent(String dContent) {
        this.dContent = dContent;
    }

    public Date getdCreateDate() {
        return dCreateDate;
    }

    public void setdCreateDate(Date dCreateDate) {
        this.dCreateDate = dCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.dId;
    }

    @Override
    public String toString() {
        return "Diary{" +
        ", dId=" + dId +
        ", uId=" + uId +
        ", dContent=" + dContent +
        ", dCreateDate=" + dCreateDate +
        "}";
    }
}

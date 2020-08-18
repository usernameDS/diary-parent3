package com.kmu.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_user_album")
public class UserAlbum extends Model<UserAlbum> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户主键
     */
    @TableField("u_id")
    private Integer uId;
    /**
     * 相册主键
     */
    @TableField("a_id")
    private Integer aId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserAlbum{" +
        ", id=" + id +
        ", uId=" + uId +
        ", aId=" + aId +
        "}";
    }
}

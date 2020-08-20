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
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    @TableField("u_name")
    private String uName;
    @TableField("u_pswd")
    private String uPswd;
    @TableField("u_account")
    private String uAccount;
    @TableField("u_phone")
    private String uPhone;
    @TableField("u_email")
    private String uEmail;
    @TableField("u_create_date")
    private Date uCreateDate;
    @TableField("u_head_pic")
    private String uHeadPic;
    /**
     * 签名
     */
    @TableField("u_signature")
    private String uSignature;
    @TableField("u_gender")
    private String uGender;
    @TableField("u_age")
    private String uAge;


    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }



    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPswd() {
        return uPswd;
    }

    public void setuPswd(String uPswd) {
        this.uPswd = uPswd;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public Date getuCreateDate() {
        return uCreateDate;
    }

    public void setuCreateDate(Date uCreateDate) {
        this.uCreateDate = uCreateDate;
    }

    public String getuHeadPic() {
        return uHeadPic;
    }

    public void setuHeadPic(String uHeadPic) {
        this.uHeadPic = uHeadPic;
    }

    public String getuSignature() {
        return uSignature;
    }

    public void setuSignature(String uSignature) {
        this.uSignature = uSignature;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuAge() {
        return uAge;
    }

    public void setuAge(String uAge) {
        this.uAge = uAge;
    }

    @Override
    protected Serializable pkVal() {
        return this.uId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", uId=" + uId +
        ", uName=" + uName +
        ", uPswd=" + uPswd +
        ", uAccount=" + uAccount +
        ", uPhone=" + uPhone +
        ", uEmail=" + uEmail +
        ", uCreateDate=" + uCreateDate +
        ", uHeadPic=" + uHeadPic +
        ", uSignature=" + uSignature +
        ", uGender=" + uGender +
        ", uAge=" + uAge +
        "}";
    }
}

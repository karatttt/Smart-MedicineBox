package com.example.smbdoctor.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

/**
 * 
 * @TableName medication_info
 */
@TableName(value ="medication_info")
@Data
public class MedicationInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer medication_id;


    private Integer user_id;

    /**
     * 
     */

    /**
     * 
     */
    private String type;



    /**
     * 
     */
    private String imageurl;

    private String name;
    private String description;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "MedicationInfo{" +
                "medication_id=" + medication_id +
                ", user_id=" + user_id +
                ", type='" + type + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationInfo that = (MedicationInfo) o;
        return Objects.equals(medication_id, that.medication_id) && Objects.equals(user_id, that.user_id) && Objects.equals(type, that.type) && Objects.equals(imageurl, that.imageurl) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_id, user_id, type, imageurl, name, description);
    }
}
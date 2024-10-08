package com.example.reminder.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName reminder
 */
@TableName(value ="reminder")
@Builder
public class Reminder implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long reminderId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long medicationId;

    /**
     * 
     */
    private Date beginDate;

    /**
     * 
     */
    private Date reminderTime;

    /**
     * 
     */
    private Integer cycle;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getReminderId() {
        return reminderId;
    }

    /**
     * 
     */
    public void setReminderId(Long reminderId) {
        this.reminderId = reminderId;
    }

    /**
     * 
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    public Long getMedicationId() {
        return medicationId;
    }

    /**
     * 
     */
    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    /**
     * 
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 
     */
    public Date getReminderTime() {
        return reminderTime;
    }

    /**
     * 
     */
    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    /**
     * 
     */
    public Integer getCycle() {
        return cycle;
    }

    /**
     * 
     */
    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Reminder other = (Reminder) that;
        return (this.getReminderId() == null ? other.getReminderId() == null : this.getReminderId().equals(other.getReminderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMedicationId() == null ? other.getMedicationId() == null : this.getMedicationId().equals(other.getMedicationId()))
            && (this.getBeginDate() == null ? other.getBeginDate() == null : this.getBeginDate().equals(other.getBeginDate()))
            && (this.getReminderTime() == null ? other.getReminderTime() == null : this.getReminderTime().equals(other.getReminderTime()))
            && (this.getCycle() == null ? other.getCycle() == null : this.getCycle().equals(other.getCycle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReminderId() == null) ? 0 : getReminderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMedicationId() == null) ? 0 : getMedicationId().hashCode());
        result = prime * result + ((getBeginDate() == null) ? 0 : getBeginDate().hashCode());
        result = prime * result + ((getReminderTime() == null) ? 0 : getReminderTime().hashCode());
        result = prime * result + ((getCycle() == null) ? 0 : getCycle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reminderId=").append(reminderId);
        sb.append(", userId=").append(userId);
        sb.append(", medicationId=").append(medicationId);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", reminderTime=").append(reminderTime);
        sb.append(", cycle=").append(cycle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
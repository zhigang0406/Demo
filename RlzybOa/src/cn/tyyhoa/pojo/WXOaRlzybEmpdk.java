package cn.tyyhoa.pojo;

import java.util.Date;
/**
 * 出勤实体类
 * @author lss
 *
 */
public class WXOaRlzybEmpdk {
    private Integer id;				// 编号

    private Integer empid;			// 员工id

    private Integer statusAm;		// 上午打卡状态

    private Date timeAm;			// 上午打卡时间

    private Integer statusPm;		// 下午打卡状态

    private Date timePm;			// 下午打卡时间

    private Date date;				// 打卡日期

    private Integer hours;			// 请假小时数

    private String comment;			// 备注

    private WXOaRlzybEmpdkzd oaRlzybEmpdkzdam = new WXOaRlzybEmpdkzd();	// 上午打卡状态实体类

    private WXOaRlzybEmpdkzd oaRlzybEmpdkzdpm = new WXOaRlzybEmpdkzd();	// 下午打卡状态实体类
    
    private WXOaRlzybEmployee oaRlzybEmployee = new WXOaRlzybEmployee();// 员工实体类

	public WXOaRlzybEmpdkzd getOaRlzybEmpdkzdam() {
		return oaRlzybEmpdkzdam;
	}

	public void setOaRlzybEmpdkzdam(WXOaRlzybEmpdkzd oaRlzybEmpdkzdam) {
		this.oaRlzybEmpdkzdam = oaRlzybEmpdkzdam;
	}

	public WXOaRlzybEmpdkzd getOaRlzybEmpdkzdpm() {
		return oaRlzybEmpdkzdpm;
	}

	public void setOaRlzybEmpdkzdpm(WXOaRlzybEmpdkzd oaRlzybEmpdkzdpm) {
		this.oaRlzybEmpdkzdpm = oaRlzybEmpdkzdpm;
	}

	public WXOaRlzybEmployee getOaRlzybEmployee() {
		return oaRlzybEmployee;
	}

	public void setOaRlzybEmployee(WXOaRlzybEmployee oaRlzybEmployee) {
		this.oaRlzybEmployee = oaRlzybEmployee;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getStatusAm() {
        return statusAm;
    }

    public void setStatusAm(Integer statusAm) {
        this.statusAm = statusAm;
    }

    public Date getTimeAm() {
        return timeAm;
    }

    public void setTimeAm(Date timeAm) {
        this.timeAm = timeAm;
    }

    public Integer getStatusPm() {
        return statusPm;
    }

    public void setStatusPm(Integer statusPm) {
        this.statusPm = statusPm;
    }

    public Date getTimePm() {
        return timePm;
    }

    public void setTimePm(Date timePm) {
        this.timePm = timePm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	@Override
	public String toString() {
		return "WXOaRlzybEmpdk [id=" + id + ", empid=" + empid + ", statusAm=" + statusAm + ", timeAm=" + timeAm
				+ ", statusPm=" + statusPm + ", timePm=" + timePm + ", date=" + date + ", hours=" + hours + ", comment="
				+ comment + ", oaRlzybEmpdkzdam=" + oaRlzybEmpdkzdam + ", oaRlzybEmpdkzdpm=" + oaRlzybEmpdkzdpm
				+ ", oaRlzybEmployee=" + oaRlzybEmployee + "]";
	}
    
}
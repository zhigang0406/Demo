package cn.tyyhoa.pojo;
/**
 * 民族
 * @author lenove ch
 *
 */
public class OaRlzybNative {
    private Integer naNo;

    private String naName;

    public Integer getNaNo() {
        return naNo;
    }

    public void setNaNo(Integer naNo) {
        this.naNo = naNo;
    }

    public String getNaName() {
        return naName;
    }

    public void setNaName(String naName) {
        this.naName = naName == null ? null : naName.trim();
    }
}
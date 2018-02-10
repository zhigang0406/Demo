package cn.tyyhoa.pojo;

import java.util.Date;
/**
 * 员工mapper层
 * @author lss
 *
 */
public class WXOaRlzybEmployee {
	private WXOaRlzybDepartment oaRlzybDepartment = new WXOaRlzybDepartment();	// ����ʵ����
	
	private WXOaRlzybPosition oaRlzybPosition = new WXOaRlzybPosition();		// ��λʵ����

	private Integer empId;

    private String empName;

    private String empIdcard;

    private String empNameSimple;

    private String empPhone;

    private String empPoliticalStatus;

    private String empSex;

    private String empMaritalStatus;

    private String nationName;

    private String empEmail;

    private String empHobby;

    private Integer empProvince;

    private Integer empCity;

    private Integer empCounty;

    private String empAddress;

    private String empContactName;

    private String empContactPhone;

    private String empContactRelationship;

    private String empContactAddress;

    private String empEmploymentNature;

    private String empPhotoPath;

    private Date empEntryDate;

    private Date empTryoutEndDate;

    private String empNowStatus;

    private String empTechnicalTitleName;

    private Integer empGradeId;

    private Integer empRegistrant;

    private String empSalaryCardnumber;

    private String empMedicalInsuranceCardnumber;

    private String empEndowmentInsuranceCardnumber;

    private String empIdcardFront;

    private String empIdcardReverse;

    private String empDegreeCertificate;

    private String empEducationCertificate;

    private String empTechnicalTitlePath;

    private String empEducationExperience;

    private String empWorkExperience;

    private String empTrainExperience;

    private String empSocietyRelation;

    private String empRemarks;

    private String empDelectstatus;

    private Integer empDepartment;				// ����

    private Integer empPosition;				// ְλ

    private String empEducationalBackground;

    private Integer empAge;

    private Date empBirthday;

    private String empOriginDetail;

    private String empNowProvince;

    private String empNowCity;

    private String empNowCounty;

    private String empNowDetail;

    private String empContactAddressProvince;

    private String empContactAddressCity;

    private String empContactAddressCounty;

    private String empContactAddressDetail;

    private Date createTime;
	
    public WXOaRlzybDepartment getOaRlzybDepartment() {
		return oaRlzybDepartment;
	}

	public void setOaRlzybDepartment(WXOaRlzybDepartment oaRlzybDepartment) {
		this.oaRlzybDepartment = oaRlzybDepartment;
	}

	public WXOaRlzybPosition getOaRlzybPosition() {
		return oaRlzybPosition;
	}

	public void setOaRlzybPosition(WXOaRlzybPosition oaRlzybPosition) {
		this.oaRlzybPosition = oaRlzybPosition;
	}

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpIdcard() {
        return empIdcard;
    }

    public void setEmpIdcard(String empIdcard) {
        this.empIdcard = empIdcard == null ? null : empIdcard.trim();
    }

    public String getEmpNameSimple() {
        return empNameSimple;
    }

    public void setEmpNameSimple(String empNameSimple) {
        this.empNameSimple = empNameSimple == null ? null : empNameSimple.trim();
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone == null ? null : empPhone.trim();
    }

    public String getEmpPoliticalStatus() {
        return empPoliticalStatus;
    }

    public void setEmpPoliticalStatus(String empPoliticalStatus) {
        this.empPoliticalStatus = empPoliticalStatus == null ? null : empPoliticalStatus.trim();
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex == null ? null : empSex.trim();
    }

    public String getEmpMaritalStatus() {
        return empMaritalStatus;
    }

    public void setEmpMaritalStatus(String empMaritalStatus) {
        this.empMaritalStatus = empMaritalStatus == null ? null : empMaritalStatus.trim();
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName == null ? null : nationName.trim();
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail == null ? null : empEmail.trim();
    }

    public String getEmpHobby() {
        return empHobby;
    }

    public void setEmpHobby(String empHobby) {
        this.empHobby = empHobby == null ? null : empHobby.trim();
    }

    public Integer getEmpProvince() {
        return empProvince;
    }

    public void setEmpProvince(Integer empProvince) {
        this.empProvince = empProvince;
    }

    public Integer getEmpCity() {
        return empCity;
    }

    public void setEmpCity(Integer empCity) {
        this.empCity = empCity;
    }

    public Integer getEmpCounty() {
        return empCounty;
    }

    public void setEmpCounty(Integer empCounty) {
        this.empCounty = empCounty;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress == null ? null : empAddress.trim();
    }

    public String getEmpContactName() {
        return empContactName;
    }

    public void setEmpContactName(String empContactName) {
        this.empContactName = empContactName == null ? null : empContactName.trim();
    }

    public String getEmpContactPhone() {
        return empContactPhone;
    }

    public void setEmpContactPhone(String empContactPhone) {
        this.empContactPhone = empContactPhone == null ? null : empContactPhone.trim();
    }

    public String getEmpContactRelationship() {
        return empContactRelationship;
    }

    public void setEmpContactRelationship(String empContactRelationship) {
        this.empContactRelationship = empContactRelationship == null ? null : empContactRelationship.trim();
    }

    public String getEmpContactAddress() {
        return empContactAddress;
    }

    public void setEmpContactAddress(String empContactAddress) {
        this.empContactAddress = empContactAddress == null ? null : empContactAddress.trim();
    }

    public String getEmpEmploymentNature() {
        return empEmploymentNature;
    }

    public void setEmpEmploymentNature(String empEmploymentNature) {
        this.empEmploymentNature = empEmploymentNature == null ? null : empEmploymentNature.trim();
    }

    public String getEmpPhotoPath() {
        return empPhotoPath;
    }

    public void setEmpPhotoPath(String empPhotoPath) {
        this.empPhotoPath = empPhotoPath == null ? null : empPhotoPath.trim();
    }

    public Date getEmpEntryDate() {
        return empEntryDate;
    }

    public void setEmpEntryDate(Date empEntryDate) {
        this.empEntryDate = empEntryDate;
    }

    public Date getEmpTryoutEndDate() {
        return empTryoutEndDate;
    }

    public void setEmpTryoutEndDate(Date empTryoutEndDate) {
        this.empTryoutEndDate = empTryoutEndDate;
    }

    public String getEmpNowStatus() {
        return empNowStatus;
    }

    public void setEmpNowStatus(String empNowStatus) {
        this.empNowStatus = empNowStatus == null ? null : empNowStatus.trim();
    }

    public String getEmpTechnicalTitleName() {
        return empTechnicalTitleName;
    }

    public void setEmpTechnicalTitleName(String empTechnicalTitleName) {
        this.empTechnicalTitleName = empTechnicalTitleName == null ? null : empTechnicalTitleName.trim();
    }

    public Integer getEmpGradeId() {
        return empGradeId;
    }

    public void setEmpGradeId(Integer empGradeId) {
        this.empGradeId = empGradeId;
    }

    public Integer getEmpRegistrant() {
        return empRegistrant;
    }

    public void setEmpRegistrant(Integer empRegistrant) {
        this.empRegistrant = empRegistrant;
    }

    public String getEmpSalaryCardnumber() {
        return empSalaryCardnumber;
    }

    public void setEmpSalaryCardnumber(String empSalaryCardnumber) {
        this.empSalaryCardnumber = empSalaryCardnumber == null ? null : empSalaryCardnumber.trim();
    }

    public String getEmpMedicalInsuranceCardnumber() {
        return empMedicalInsuranceCardnumber;
    }

    public void setEmpMedicalInsuranceCardnumber(String empMedicalInsuranceCardnumber) {
        this.empMedicalInsuranceCardnumber = empMedicalInsuranceCardnumber == null ? null : empMedicalInsuranceCardnumber.trim();
    }

    public String getEmpEndowmentInsuranceCardnumber() {
        return empEndowmentInsuranceCardnumber;
    }

    public void setEmpEndowmentInsuranceCardnumber(String empEndowmentInsuranceCardnumber) {
        this.empEndowmentInsuranceCardnumber = empEndowmentInsuranceCardnumber == null ? null : empEndowmentInsuranceCardnumber.trim();
    }

    public String getEmpIdcardFront() {
        return empIdcardFront;
    }

    public void setEmpIdcardFront(String empIdcardFront) {
        this.empIdcardFront = empIdcardFront == null ? null : empIdcardFront.trim();
    }

    public String getEmpIdcardReverse() {
        return empIdcardReverse;
    }

    public void setEmpIdcardReverse(String empIdcardReverse) {
        this.empIdcardReverse = empIdcardReverse == null ? null : empIdcardReverse.trim();
    }

    public String getEmpDegreeCertificate() {
        return empDegreeCertificate;
    }

    public void setEmpDegreeCertificate(String empDegreeCertificate) {
        this.empDegreeCertificate = empDegreeCertificate == null ? null : empDegreeCertificate.trim();
    }

    public String getEmpEducationCertificate() {
        return empEducationCertificate;
    }

    public void setEmpEducationCertificate(String empEducationCertificate) {
        this.empEducationCertificate = empEducationCertificate == null ? null : empEducationCertificate.trim();
    }

    public String getEmpTechnicalTitlePath() {
        return empTechnicalTitlePath;
    }

    public void setEmpTechnicalTitlePath(String empTechnicalTitlePath) {
        this.empTechnicalTitlePath = empTechnicalTitlePath == null ? null : empTechnicalTitlePath.trim();
    }

    public String getEmpEducationExperience() {
        return empEducationExperience;
    }

    public void setEmpEducationExperience(String empEducationExperience) {
        this.empEducationExperience = empEducationExperience == null ? null : empEducationExperience.trim();
    }

    public String getEmpWorkExperience() {
        return empWorkExperience;
    }

    public void setEmpWorkExperience(String empWorkExperience) {
        this.empWorkExperience = empWorkExperience == null ? null : empWorkExperience.trim();
    }

    public String getEmpTrainExperience() {
        return empTrainExperience;
    }

    public void setEmpTrainExperience(String empTrainExperience) {
        this.empTrainExperience = empTrainExperience == null ? null : empTrainExperience.trim();
    }

    public String getEmpSocietyRelation() {
        return empSocietyRelation;
    }

    public void setEmpSocietyRelation(String empSocietyRelation) {
        this.empSocietyRelation = empSocietyRelation == null ? null : empSocietyRelation.trim();
    }

    public String getEmpRemarks() {
        return empRemarks;
    }

    public void setEmpRemarks(String empRemarks) {
        this.empRemarks = empRemarks == null ? null : empRemarks.trim();
    }

    public String getEmpDelectstatus() {
        return empDelectstatus;
    }

    public void setEmpDelectstatus(String empDelectstatus) {
        this.empDelectstatus = empDelectstatus == null ? null : empDelectstatus.trim();
    }

    public Integer getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(Integer empDepartment) {
        this.empDepartment = empDepartment;
    }

    public Integer getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(Integer empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpEducationalBackground() {
        return empEducationalBackground;
    }

    public void setEmpEducationalBackground(String empEducationalBackground) {
        this.empEducationalBackground = empEducationalBackground == null ? null : empEducationalBackground.trim();
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpOriginDetail() {
        return empOriginDetail;
    }

    public void setEmpOriginDetail(String empOriginDetail) {
        this.empOriginDetail = empOriginDetail == null ? null : empOriginDetail.trim();
    }

    public String getEmpNowProvince() {
        return empNowProvince;
    }

    public void setEmpNowProvince(String empNowProvince) {
        this.empNowProvince = empNowProvince == null ? null : empNowProvince.trim();
    }

    public String getEmpNowCity() {
        return empNowCity;
    }

    public void setEmpNowCity(String empNowCity) {
        this.empNowCity = empNowCity == null ? null : empNowCity.trim();
    }

    public String getEmpNowCounty() {
        return empNowCounty;
    }

    public void setEmpNowCounty(String empNowCounty) {
        this.empNowCounty = empNowCounty == null ? null : empNowCounty.trim();
    }

    public String getEmpNowDetail() {
        return empNowDetail;
    }

    public void setEmpNowDetail(String empNowDetail) {
        this.empNowDetail = empNowDetail == null ? null : empNowDetail.trim();
    }

    public String getEmpContactAddressProvince() {
        return empContactAddressProvince;
    }

    public void setEmpContactAddressProvince(String empContactAddressProvince) {
        this.empContactAddressProvince = empContactAddressProvince == null ? null : empContactAddressProvince.trim();
    }

    public String getEmpContactAddressCity() {
        return empContactAddressCity;
    }

    public void setEmpContactAddressCity(String empContactAddressCity) {
        this.empContactAddressCity = empContactAddressCity == null ? null : empContactAddressCity.trim();
    }

    public String getEmpContactAddressCounty() {
        return empContactAddressCounty;
    }

    public void setEmpContactAddressCounty(String empContactAddressCounty) {
        this.empContactAddressCounty = empContactAddressCounty == null ? null : empContactAddressCounty.trim();
    }

    public String getEmpContactAddressDetail() {
        return empContactAddressDetail;
    }

    public void setEmpContactAddressDetail(String empContactAddressDetail) {
        this.empContactAddressDetail = empContactAddressDetail == null ? null : empContactAddressDetail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
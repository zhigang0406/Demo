package cn.tyyhoa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXOaRlzybEmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WXOaRlzybEmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardIsNull() {
            addCriterion("emp_idcard is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardIsNotNull() {
            addCriterion("emp_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardEqualTo(String value) {
            addCriterion("emp_idcard =", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardNotEqualTo(String value) {
            addCriterion("emp_idcard <>", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardGreaterThan(String value) {
            addCriterion("emp_idcard >", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("emp_idcard >=", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardLessThan(String value) {
            addCriterion("emp_idcard <", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardLessThanOrEqualTo(String value) {
            addCriterion("emp_idcard <=", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardLike(String value) {
            addCriterion("emp_idcard like", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardNotLike(String value) {
            addCriterion("emp_idcard not like", value, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardIn(List<String> values) {
            addCriterion("emp_idcard in", values, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardNotIn(List<String> values) {
            addCriterion("emp_idcard not in", values, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardBetween(String value1, String value2) {
            addCriterion("emp_idcard between", value1, value2, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardNotBetween(String value1, String value2) {
            addCriterion("emp_idcard not between", value1, value2, "empIdcard");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleIsNull() {
            addCriterion("emp_name_simple is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleIsNotNull() {
            addCriterion("emp_name_simple is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleEqualTo(String value) {
            addCriterion("emp_name_simple =", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleNotEqualTo(String value) {
            addCriterion("emp_name_simple <>", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleGreaterThan(String value) {
            addCriterion("emp_name_simple >", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name_simple >=", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleLessThan(String value) {
            addCriterion("emp_name_simple <", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleLessThanOrEqualTo(String value) {
            addCriterion("emp_name_simple <=", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleLike(String value) {
            addCriterion("emp_name_simple like", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleNotLike(String value) {
            addCriterion("emp_name_simple not like", value, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleIn(List<String> values) {
            addCriterion("emp_name_simple in", values, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleNotIn(List<String> values) {
            addCriterion("emp_name_simple not in", values, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleBetween(String value1, String value2) {
            addCriterion("emp_name_simple between", value1, value2, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpNameSimpleNotBetween(String value1, String value2) {
            addCriterion("emp_name_simple not between", value1, value2, "empNameSimple");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNull() {
            addCriterion("emp_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIsNotNull() {
            addCriterion("emp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneEqualTo(String value) {
            addCriterion("emp_phone =", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotEqualTo(String value) {
            addCriterion("emp_phone <>", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThan(String value) {
            addCriterion("emp_phone >", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_phone >=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThan(String value) {
            addCriterion("emp_phone <", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_phone <=", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneLike(String value) {
            addCriterion("emp_phone like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotLike(String value) {
            addCriterion("emp_phone not like", value, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneIn(List<String> values) {
            addCriterion("emp_phone in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotIn(List<String> values) {
            addCriterion("emp_phone not in", values, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneBetween(String value1, String value2) {
            addCriterion("emp_phone between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPhoneNotBetween(String value1, String value2) {
            addCriterion("emp_phone not between", value1, value2, "empPhone");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusIsNull() {
            addCriterion("emp_political_status is null");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusIsNotNull() {
            addCriterion("emp_political_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusEqualTo(String value) {
            addCriterion("emp_political_status =", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusNotEqualTo(String value) {
            addCriterion("emp_political_status <>", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusGreaterThan(String value) {
            addCriterion("emp_political_status >", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("emp_political_status >=", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusLessThan(String value) {
            addCriterion("emp_political_status <", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusLessThanOrEqualTo(String value) {
            addCriterion("emp_political_status <=", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusLike(String value) {
            addCriterion("emp_political_status like", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusNotLike(String value) {
            addCriterion("emp_political_status not like", value, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusIn(List<String> values) {
            addCriterion("emp_political_status in", values, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusNotIn(List<String> values) {
            addCriterion("emp_political_status not in", values, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusBetween(String value1, String value2) {
            addCriterion("emp_political_status between", value1, value2, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpPoliticalStatusNotBetween(String value1, String value2) {
            addCriterion("emp_political_status not between", value1, value2, "empPoliticalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSexEqualTo(String value) {
            addCriterion("emp_sex =", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotEqualTo(String value) {
            addCriterion("emp_sex <>", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThan(String value) {
            addCriterion("emp_sex >", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sex >=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThan(String value) {
            addCriterion("emp_sex <", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThanOrEqualTo(String value) {
            addCriterion("emp_sex <=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLike(String value) {
            addCriterion("emp_sex like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotLike(String value) {
            addCriterion("emp_sex not like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexIn(List<String> values) {
            addCriterion("emp_sex in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotIn(List<String> values) {
            addCriterion("emp_sex not in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexBetween(String value1, String value2) {
            addCriterion("emp_sex between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotBetween(String value1, String value2) {
            addCriterion("emp_sex not between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusIsNull() {
            addCriterion("emp_marital_status is null");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusIsNotNull() {
            addCriterion("emp_marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusEqualTo(String value) {
            addCriterion("emp_marital_status =", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusNotEqualTo(String value) {
            addCriterion("emp_marital_status <>", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusGreaterThan(String value) {
            addCriterion("emp_marital_status >", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("emp_marital_status >=", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusLessThan(String value) {
            addCriterion("emp_marital_status <", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("emp_marital_status <=", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusLike(String value) {
            addCriterion("emp_marital_status like", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusNotLike(String value) {
            addCriterion("emp_marital_status not like", value, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusIn(List<String> values) {
            addCriterion("emp_marital_status in", values, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusNotIn(List<String> values) {
            addCriterion("emp_marital_status not in", values, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusBetween(String value1, String value2) {
            addCriterion("emp_marital_status between", value1, value2, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andEmpMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("emp_marital_status not between", value1, value2, "empMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andNationNameIsNull() {
            addCriterion("nation_name is null");
            return (Criteria) this;
        }

        public Criteria andNationNameIsNotNull() {
            addCriterion("nation_name is not null");
            return (Criteria) this;
        }

        public Criteria andNationNameEqualTo(String value) {
            addCriterion("nation_name =", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameNotEqualTo(String value) {
            addCriterion("nation_name <>", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameGreaterThan(String value) {
            addCriterion("nation_name >", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameGreaterThanOrEqualTo(String value) {
            addCriterion("nation_name >=", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameLessThan(String value) {
            addCriterion("nation_name <", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameLessThanOrEqualTo(String value) {
            addCriterion("nation_name <=", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameLike(String value) {
            addCriterion("nation_name like", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameNotLike(String value) {
            addCriterion("nation_name not like", value, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameIn(List<String> values) {
            addCriterion("nation_name in", values, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameNotIn(List<String> values) {
            addCriterion("nation_name not in", values, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameBetween(String value1, String value2) {
            addCriterion("nation_name between", value1, value2, "nationName");
            return (Criteria) this;
        }

        public Criteria andNationNameNotBetween(String value1, String value2) {
            addCriterion("nation_name not between", value1, value2, "nationName");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNull() {
            addCriterion("emp_Email is null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIsNotNull() {
            addCriterion("emp_Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEmailEqualTo(String value) {
            addCriterion("emp_Email =", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotEqualTo(String value) {
            addCriterion("emp_Email <>", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThan(String value) {
            addCriterion("emp_Email >", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_Email >=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThan(String value) {
            addCriterion("emp_Email <", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLessThanOrEqualTo(String value) {
            addCriterion("emp_Email <=", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailLike(String value) {
            addCriterion("emp_Email like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotLike(String value) {
            addCriterion("emp_Email not like", value, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailIn(List<String> values) {
            addCriterion("emp_Email in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotIn(List<String> values) {
            addCriterion("emp_Email not in", values, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailBetween(String value1, String value2) {
            addCriterion("emp_Email between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpEmailNotBetween(String value1, String value2) {
            addCriterion("emp_Email not between", value1, value2, "empEmail");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyIsNull() {
            addCriterion("emp_hobby is null");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyIsNotNull() {
            addCriterion("emp_hobby is not null");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyEqualTo(String value) {
            addCriterion("emp_hobby =", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyNotEqualTo(String value) {
            addCriterion("emp_hobby <>", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyGreaterThan(String value) {
            addCriterion("emp_hobby >", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("emp_hobby >=", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyLessThan(String value) {
            addCriterion("emp_hobby <", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyLessThanOrEqualTo(String value) {
            addCriterion("emp_hobby <=", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyLike(String value) {
            addCriterion("emp_hobby like", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyNotLike(String value) {
            addCriterion("emp_hobby not like", value, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyIn(List<String> values) {
            addCriterion("emp_hobby in", values, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyNotIn(List<String> values) {
            addCriterion("emp_hobby not in", values, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyBetween(String value1, String value2) {
            addCriterion("emp_hobby between", value1, value2, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpHobbyNotBetween(String value1, String value2) {
            addCriterion("emp_hobby not between", value1, value2, "empHobby");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceIsNull() {
            addCriterion("emp_province is null");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceIsNotNull() {
            addCriterion("emp_province is not null");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceEqualTo(Integer value) {
            addCriterion("emp_province =", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceNotEqualTo(Integer value) {
            addCriterion("emp_province <>", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceGreaterThan(Integer value) {
            addCriterion("emp_province >", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_province >=", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceLessThan(Integer value) {
            addCriterion("emp_province <", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("emp_province <=", value, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceIn(List<Integer> values) {
            addCriterion("emp_province in", values, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceNotIn(List<Integer> values) {
            addCriterion("emp_province not in", values, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceBetween(Integer value1, Integer value2) {
            addCriterion("emp_province between", value1, value2, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_province not between", value1, value2, "empProvince");
            return (Criteria) this;
        }

        public Criteria andEmpCityIsNull() {
            addCriterion("emp_city is null");
            return (Criteria) this;
        }

        public Criteria andEmpCityIsNotNull() {
            addCriterion("emp_city is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCityEqualTo(Integer value) {
            addCriterion("emp_city =", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityNotEqualTo(Integer value) {
            addCriterion("emp_city <>", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityGreaterThan(Integer value) {
            addCriterion("emp_city >", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_city >=", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityLessThan(Integer value) {
            addCriterion("emp_city <", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityLessThanOrEqualTo(Integer value) {
            addCriterion("emp_city <=", value, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityIn(List<Integer> values) {
            addCriterion("emp_city in", values, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityNotIn(List<Integer> values) {
            addCriterion("emp_city not in", values, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityBetween(Integer value1, Integer value2) {
            addCriterion("emp_city between", value1, value2, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCityNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_city not between", value1, value2, "empCity");
            return (Criteria) this;
        }

        public Criteria andEmpCountyIsNull() {
            addCriterion("emp_county is null");
            return (Criteria) this;
        }

        public Criteria andEmpCountyIsNotNull() {
            addCriterion("emp_county is not null");
            return (Criteria) this;
        }

        public Criteria andEmpCountyEqualTo(Integer value) {
            addCriterion("emp_county =", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyNotEqualTo(Integer value) {
            addCriterion("emp_county <>", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyGreaterThan(Integer value) {
            addCriterion("emp_county >", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_county >=", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyLessThan(Integer value) {
            addCriterion("emp_county <", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyLessThanOrEqualTo(Integer value) {
            addCriterion("emp_county <=", value, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyIn(List<Integer> values) {
            addCriterion("emp_county in", values, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyNotIn(List<Integer> values) {
            addCriterion("emp_county not in", values, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyBetween(Integer value1, Integer value2) {
            addCriterion("emp_county between", value1, value2, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_county not between", value1, value2, "empCounty");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNull() {
            addCriterion("emp_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIsNotNull() {
            addCriterion("emp_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAddressEqualTo(String value) {
            addCriterion("emp_address =", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotEqualTo(String value) {
            addCriterion("emp_address <>", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThan(String value) {
            addCriterion("emp_address >", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_address >=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThan(String value) {
            addCriterion("emp_address <", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_address <=", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressLike(String value) {
            addCriterion("emp_address like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotLike(String value) {
            addCriterion("emp_address not like", value, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressIn(List<String> values) {
            addCriterion("emp_address in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotIn(List<String> values) {
            addCriterion("emp_address not in", values, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressBetween(String value1, String value2) {
            addCriterion("emp_address between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpAddressNotBetween(String value1, String value2) {
            addCriterion("emp_address not between", value1, value2, "empAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameIsNull() {
            addCriterion("emp_contact_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameIsNotNull() {
            addCriterion("emp_contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameEqualTo(String value) {
            addCriterion("emp_contact_name =", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameNotEqualTo(String value) {
            addCriterion("emp_contact_name <>", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameGreaterThan(String value) {
            addCriterion("emp_contact_name >", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_name >=", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameLessThan(String value) {
            addCriterion("emp_contact_name <", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_name <=", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameLike(String value) {
            addCriterion("emp_contact_name like", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameNotLike(String value) {
            addCriterion("emp_contact_name not like", value, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameIn(List<String> values) {
            addCriterion("emp_contact_name in", values, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameNotIn(List<String> values) {
            addCriterion("emp_contact_name not in", values, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameBetween(String value1, String value2) {
            addCriterion("emp_contact_name between", value1, value2, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactNameNotBetween(String value1, String value2) {
            addCriterion("emp_contact_name not between", value1, value2, "empContactName");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneIsNull() {
            addCriterion("emp_contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneIsNotNull() {
            addCriterion("emp_contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneEqualTo(String value) {
            addCriterion("emp_contact_phone =", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneNotEqualTo(String value) {
            addCriterion("emp_contact_phone <>", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneGreaterThan(String value) {
            addCriterion("emp_contact_phone >", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_phone >=", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneLessThan(String value) {
            addCriterion("emp_contact_phone <", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_phone <=", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneLike(String value) {
            addCriterion("emp_contact_phone like", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneNotLike(String value) {
            addCriterion("emp_contact_phone not like", value, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneIn(List<String> values) {
            addCriterion("emp_contact_phone in", values, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneNotIn(List<String> values) {
            addCriterion("emp_contact_phone not in", values, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneBetween(String value1, String value2) {
            addCriterion("emp_contact_phone between", value1, value2, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactPhoneNotBetween(String value1, String value2) {
            addCriterion("emp_contact_phone not between", value1, value2, "empContactPhone");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipIsNull() {
            addCriterion("emp_contact_relationship is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipIsNotNull() {
            addCriterion("emp_contact_relationship is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipEqualTo(String value) {
            addCriterion("emp_contact_relationship =", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipNotEqualTo(String value) {
            addCriterion("emp_contact_relationship <>", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipGreaterThan(String value) {
            addCriterion("emp_contact_relationship >", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_relationship >=", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipLessThan(String value) {
            addCriterion("emp_contact_relationship <", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_relationship <=", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipLike(String value) {
            addCriterion("emp_contact_relationship like", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipNotLike(String value) {
            addCriterion("emp_contact_relationship not like", value, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipIn(List<String> values) {
            addCriterion("emp_contact_relationship in", values, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipNotIn(List<String> values) {
            addCriterion("emp_contact_relationship not in", values, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipBetween(String value1, String value2) {
            addCriterion("emp_contact_relationship between", value1, value2, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactRelationshipNotBetween(String value1, String value2) {
            addCriterion("emp_contact_relationship not between", value1, value2, "empContactRelationship");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressIsNull() {
            addCriterion("emp_contact_address is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressIsNotNull() {
            addCriterion("emp_contact_address is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressEqualTo(String value) {
            addCriterion("emp_contact_address =", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressNotEqualTo(String value) {
            addCriterion("emp_contact_address <>", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressGreaterThan(String value) {
            addCriterion("emp_contact_address >", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_address >=", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressLessThan(String value) {
            addCriterion("emp_contact_address <", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_address <=", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressLike(String value) {
            addCriterion("emp_contact_address like", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressNotLike(String value) {
            addCriterion("emp_contact_address not like", value, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressIn(List<String> values) {
            addCriterion("emp_contact_address in", values, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressNotIn(List<String> values) {
            addCriterion("emp_contact_address not in", values, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressBetween(String value1, String value2) {
            addCriterion("emp_contact_address between", value1, value2, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressNotBetween(String value1, String value2) {
            addCriterion("emp_contact_address not between", value1, value2, "empContactAddress");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureIsNull() {
            addCriterion("emp_Employment_nature is null");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureIsNotNull() {
            addCriterion("emp_Employment_nature is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureEqualTo(String value) {
            addCriterion("emp_Employment_nature =", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureNotEqualTo(String value) {
            addCriterion("emp_Employment_nature <>", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureGreaterThan(String value) {
            addCriterion("emp_Employment_nature >", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureGreaterThanOrEqualTo(String value) {
            addCriterion("emp_Employment_nature >=", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureLessThan(String value) {
            addCriterion("emp_Employment_nature <", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureLessThanOrEqualTo(String value) {
            addCriterion("emp_Employment_nature <=", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureLike(String value) {
            addCriterion("emp_Employment_nature like", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureNotLike(String value) {
            addCriterion("emp_Employment_nature not like", value, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureIn(List<String> values) {
            addCriterion("emp_Employment_nature in", values, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureNotIn(List<String> values) {
            addCriterion("emp_Employment_nature not in", values, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureBetween(String value1, String value2) {
            addCriterion("emp_Employment_nature between", value1, value2, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpEmploymentNatureNotBetween(String value1, String value2) {
            addCriterion("emp_Employment_nature not between", value1, value2, "empEmploymentNature");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathIsNull() {
            addCriterion("emp_photo_path is null");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathIsNotNull() {
            addCriterion("emp_photo_path is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathEqualTo(String value) {
            addCriterion("emp_photo_path =", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathNotEqualTo(String value) {
            addCriterion("emp_photo_path <>", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathGreaterThan(String value) {
            addCriterion("emp_photo_path >", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathGreaterThanOrEqualTo(String value) {
            addCriterion("emp_photo_path >=", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathLessThan(String value) {
            addCriterion("emp_photo_path <", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathLessThanOrEqualTo(String value) {
            addCriterion("emp_photo_path <=", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathLike(String value) {
            addCriterion("emp_photo_path like", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathNotLike(String value) {
            addCriterion("emp_photo_path not like", value, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathIn(List<String> values) {
            addCriterion("emp_photo_path in", values, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathNotIn(List<String> values) {
            addCriterion("emp_photo_path not in", values, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathBetween(String value1, String value2) {
            addCriterion("emp_photo_path between", value1, value2, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpPhotoPathNotBetween(String value1, String value2) {
            addCriterion("emp_photo_path not between", value1, value2, "empPhotoPath");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateIsNull() {
            addCriterion("emp_Entry_date is null");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateIsNotNull() {
            addCriterion("emp_Entry_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateEqualTo(Date value) {
            addCriterion("emp_Entry_date =", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateNotEqualTo(Date value) {
            addCriterion("emp_Entry_date <>", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateGreaterThan(Date value) {
            addCriterion("emp_Entry_date >", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("emp_Entry_date >=", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateLessThan(Date value) {
            addCriterion("emp_Entry_date <", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateLessThanOrEqualTo(Date value) {
            addCriterion("emp_Entry_date <=", value, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateIn(List<Date> values) {
            addCriterion("emp_Entry_date in", values, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateNotIn(List<Date> values) {
            addCriterion("emp_Entry_date not in", values, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateBetween(Date value1, Date value2) {
            addCriterion("emp_Entry_date between", value1, value2, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpEntryDateNotBetween(Date value1, Date value2) {
            addCriterion("emp_Entry_date not between", value1, value2, "empEntryDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateIsNull() {
            addCriterion("emp_tryout_end_date is null");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateIsNotNull() {
            addCriterion("emp_tryout_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateEqualTo(Date value) {
            addCriterion("emp_tryout_end_date =", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateNotEqualTo(Date value) {
            addCriterion("emp_tryout_end_date <>", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateGreaterThan(Date value) {
            addCriterion("emp_tryout_end_date >", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("emp_tryout_end_date >=", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateLessThan(Date value) {
            addCriterion("emp_tryout_end_date <", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateLessThanOrEqualTo(Date value) {
            addCriterion("emp_tryout_end_date <=", value, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateIn(List<Date> values) {
            addCriterion("emp_tryout_end_date in", values, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateNotIn(List<Date> values) {
            addCriterion("emp_tryout_end_date not in", values, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateBetween(Date value1, Date value2) {
            addCriterion("emp_tryout_end_date between", value1, value2, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpTryoutEndDateNotBetween(Date value1, Date value2) {
            addCriterion("emp_tryout_end_date not between", value1, value2, "empTryoutEndDate");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusIsNull() {
            addCriterion("emp_now_status is null");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusIsNotNull() {
            addCriterion("emp_now_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusEqualTo(String value) {
            addCriterion("emp_now_status =", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusNotEqualTo(String value) {
            addCriterion("emp_now_status <>", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusGreaterThan(String value) {
            addCriterion("emp_now_status >", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("emp_now_status >=", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusLessThan(String value) {
            addCriterion("emp_now_status <", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusLessThanOrEqualTo(String value) {
            addCriterion("emp_now_status <=", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusLike(String value) {
            addCriterion("emp_now_status like", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusNotLike(String value) {
            addCriterion("emp_now_status not like", value, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusIn(List<String> values) {
            addCriterion("emp_now_status in", values, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusNotIn(List<String> values) {
            addCriterion("emp_now_status not in", values, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusBetween(String value1, String value2) {
            addCriterion("emp_now_status between", value1, value2, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpNowStatusNotBetween(String value1, String value2) {
            addCriterion("emp_now_status not between", value1, value2, "empNowStatus");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameIsNull() {
            addCriterion("emp_technical_title_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameIsNotNull() {
            addCriterion("emp_technical_title_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameEqualTo(String value) {
            addCriterion("emp_technical_title_name =", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameNotEqualTo(String value) {
            addCriterion("emp_technical_title_name <>", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameGreaterThan(String value) {
            addCriterion("emp_technical_title_name >", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_technical_title_name >=", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameLessThan(String value) {
            addCriterion("emp_technical_title_name <", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameLessThanOrEqualTo(String value) {
            addCriterion("emp_technical_title_name <=", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameLike(String value) {
            addCriterion("emp_technical_title_name like", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameNotLike(String value) {
            addCriterion("emp_technical_title_name not like", value, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameIn(List<String> values) {
            addCriterion("emp_technical_title_name in", values, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameNotIn(List<String> values) {
            addCriterion("emp_technical_title_name not in", values, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameBetween(String value1, String value2) {
            addCriterion("emp_technical_title_name between", value1, value2, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitleNameNotBetween(String value1, String value2) {
            addCriterion("emp_technical_title_name not between", value1, value2, "empTechnicalTitleName");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdIsNull() {
            addCriterion("emp_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdIsNotNull() {
            addCriterion("emp_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdEqualTo(Integer value) {
            addCriterion("emp_grade_id =", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdNotEqualTo(Integer value) {
            addCriterion("emp_grade_id <>", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdGreaterThan(Integer value) {
            addCriterion("emp_grade_id >", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_grade_id >=", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdLessThan(Integer value) {
            addCriterion("emp_grade_id <", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_grade_id <=", value, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdIn(List<Integer> values) {
            addCriterion("emp_grade_id in", values, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdNotIn(List<Integer> values) {
            addCriterion("emp_grade_id not in", values, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_grade_id between", value1, value2, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_grade_id not between", value1, value2, "empGradeId");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantIsNull() {
            addCriterion("emp_registrant is null");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantIsNotNull() {
            addCriterion("emp_registrant is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantEqualTo(Integer value) {
            addCriterion("emp_registrant =", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantNotEqualTo(Integer value) {
            addCriterion("emp_registrant <>", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantGreaterThan(Integer value) {
            addCriterion("emp_registrant >", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_registrant >=", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantLessThan(Integer value) {
            addCriterion("emp_registrant <", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantLessThanOrEqualTo(Integer value) {
            addCriterion("emp_registrant <=", value, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantIn(List<Integer> values) {
            addCriterion("emp_registrant in", values, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantNotIn(List<Integer> values) {
            addCriterion("emp_registrant not in", values, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantBetween(Integer value1, Integer value2) {
            addCriterion("emp_registrant between", value1, value2, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpRegistrantNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_registrant not between", value1, value2, "empRegistrant");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberIsNull() {
            addCriterion("emp_salary_cardnumber is null");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberIsNotNull() {
            addCriterion("emp_salary_cardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberEqualTo(String value) {
            addCriterion("emp_salary_cardnumber =", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberNotEqualTo(String value) {
            addCriterion("emp_salary_cardnumber <>", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberGreaterThan(String value) {
            addCriterion("emp_salary_cardnumber >", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("emp_salary_cardnumber >=", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberLessThan(String value) {
            addCriterion("emp_salary_cardnumber <", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberLessThanOrEqualTo(String value) {
            addCriterion("emp_salary_cardnumber <=", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberLike(String value) {
            addCriterion("emp_salary_cardnumber like", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberNotLike(String value) {
            addCriterion("emp_salary_cardnumber not like", value, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberIn(List<String> values) {
            addCriterion("emp_salary_cardnumber in", values, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberNotIn(List<String> values) {
            addCriterion("emp_salary_cardnumber not in", values, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberBetween(String value1, String value2) {
            addCriterion("emp_salary_cardnumber between", value1, value2, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpSalaryCardnumberNotBetween(String value1, String value2) {
            addCriterion("emp_salary_cardnumber not between", value1, value2, "empSalaryCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberIsNull() {
            addCriterion("emp_medical_insurance_cardnumber is null");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberIsNotNull() {
            addCriterion("emp_medical_insurance_cardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberEqualTo(String value) {
            addCriterion("emp_medical_insurance_cardnumber =", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberNotEqualTo(String value) {
            addCriterion("emp_medical_insurance_cardnumber <>", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberGreaterThan(String value) {
            addCriterion("emp_medical_insurance_cardnumber >", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("emp_medical_insurance_cardnumber >=", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberLessThan(String value) {
            addCriterion("emp_medical_insurance_cardnumber <", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberLessThanOrEqualTo(String value) {
            addCriterion("emp_medical_insurance_cardnumber <=", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberLike(String value) {
            addCriterion("emp_medical_insurance_cardnumber like", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberNotLike(String value) {
            addCriterion("emp_medical_insurance_cardnumber not like", value, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberIn(List<String> values) {
            addCriterion("emp_medical_insurance_cardnumber in", values, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberNotIn(List<String> values) {
            addCriterion("emp_medical_insurance_cardnumber not in", values, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberBetween(String value1, String value2) {
            addCriterion("emp_medical_insurance_cardnumber between", value1, value2, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpMedicalInsuranceCardnumberNotBetween(String value1, String value2) {
            addCriterion("emp_medical_insurance_cardnumber not between", value1, value2, "empMedicalInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberIsNull() {
            addCriterion("emp_endowment_insurance_cardnumber is null");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberIsNotNull() {
            addCriterion("emp_endowment_insurance_cardnumber is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberEqualTo(String value) {
            addCriterion("emp_endowment_insurance_cardnumber =", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberNotEqualTo(String value) {
            addCriterion("emp_endowment_insurance_cardnumber <>", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberGreaterThan(String value) {
            addCriterion("emp_endowment_insurance_cardnumber >", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("emp_endowment_insurance_cardnumber >=", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberLessThan(String value) {
            addCriterion("emp_endowment_insurance_cardnumber <", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberLessThanOrEqualTo(String value) {
            addCriterion("emp_endowment_insurance_cardnumber <=", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberLike(String value) {
            addCriterion("emp_endowment_insurance_cardnumber like", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberNotLike(String value) {
            addCriterion("emp_endowment_insurance_cardnumber not like", value, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberIn(List<String> values) {
            addCriterion("emp_endowment_insurance_cardnumber in", values, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberNotIn(List<String> values) {
            addCriterion("emp_endowment_insurance_cardnumber not in", values, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberBetween(String value1, String value2) {
            addCriterion("emp_endowment_insurance_cardnumber between", value1, value2, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpEndowmentInsuranceCardnumberNotBetween(String value1, String value2) {
            addCriterion("emp_endowment_insurance_cardnumber not between", value1, value2, "empEndowmentInsuranceCardnumber");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontIsNull() {
            addCriterion("emp_idcard_front is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontIsNotNull() {
            addCriterion("emp_idcard_front is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontEqualTo(String value) {
            addCriterion("emp_idcard_front =", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontNotEqualTo(String value) {
            addCriterion("emp_idcard_front <>", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontGreaterThan(String value) {
            addCriterion("emp_idcard_front >", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontGreaterThanOrEqualTo(String value) {
            addCriterion("emp_idcard_front >=", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontLessThan(String value) {
            addCriterion("emp_idcard_front <", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontLessThanOrEqualTo(String value) {
            addCriterion("emp_idcard_front <=", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontLike(String value) {
            addCriterion("emp_idcard_front like", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontNotLike(String value) {
            addCriterion("emp_idcard_front not like", value, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontIn(List<String> values) {
            addCriterion("emp_idcard_front in", values, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontNotIn(List<String> values) {
            addCriterion("emp_idcard_front not in", values, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontBetween(String value1, String value2) {
            addCriterion("emp_idcard_front between", value1, value2, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardFrontNotBetween(String value1, String value2) {
            addCriterion("emp_idcard_front not between", value1, value2, "empIdcardFront");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseIsNull() {
            addCriterion("emp_idcard_reverse is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseIsNotNull() {
            addCriterion("emp_idcard_reverse is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseEqualTo(String value) {
            addCriterion("emp_idcard_reverse =", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseNotEqualTo(String value) {
            addCriterion("emp_idcard_reverse <>", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseGreaterThan(String value) {
            addCriterion("emp_idcard_reverse >", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseGreaterThanOrEqualTo(String value) {
            addCriterion("emp_idcard_reverse >=", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseLessThan(String value) {
            addCriterion("emp_idcard_reverse <", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseLessThanOrEqualTo(String value) {
            addCriterion("emp_idcard_reverse <=", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseLike(String value) {
            addCriterion("emp_idcard_reverse like", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseNotLike(String value) {
            addCriterion("emp_idcard_reverse not like", value, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseIn(List<String> values) {
            addCriterion("emp_idcard_reverse in", values, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseNotIn(List<String> values) {
            addCriterion("emp_idcard_reverse not in", values, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseBetween(String value1, String value2) {
            addCriterion("emp_idcard_reverse between", value1, value2, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpIdcardReverseNotBetween(String value1, String value2) {
            addCriterion("emp_idcard_reverse not between", value1, value2, "empIdcardReverse");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateIsNull() {
            addCriterion("emp_Degree_certificate is null");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateIsNotNull() {
            addCriterion("emp_Degree_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateEqualTo(String value) {
            addCriterion("emp_Degree_certificate =", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateNotEqualTo(String value) {
            addCriterion("emp_Degree_certificate <>", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateGreaterThan(String value) {
            addCriterion("emp_Degree_certificate >", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("emp_Degree_certificate >=", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateLessThan(String value) {
            addCriterion("emp_Degree_certificate <", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateLessThanOrEqualTo(String value) {
            addCriterion("emp_Degree_certificate <=", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateLike(String value) {
            addCriterion("emp_Degree_certificate like", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateNotLike(String value) {
            addCriterion("emp_Degree_certificate not like", value, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateIn(List<String> values) {
            addCriterion("emp_Degree_certificate in", values, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateNotIn(List<String> values) {
            addCriterion("emp_Degree_certificate not in", values, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateBetween(String value1, String value2) {
            addCriterion("emp_Degree_certificate between", value1, value2, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpDegreeCertificateNotBetween(String value1, String value2) {
            addCriterion("emp_Degree_certificate not between", value1, value2, "empDegreeCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateIsNull() {
            addCriterion("emp_Education_certificate is null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateIsNotNull() {
            addCriterion("emp_Education_certificate is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateEqualTo(String value) {
            addCriterion("emp_Education_certificate =", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateNotEqualTo(String value) {
            addCriterion("emp_Education_certificate <>", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateGreaterThan(String value) {
            addCriterion("emp_Education_certificate >", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateGreaterThanOrEqualTo(String value) {
            addCriterion("emp_Education_certificate >=", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateLessThan(String value) {
            addCriterion("emp_Education_certificate <", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateLessThanOrEqualTo(String value) {
            addCriterion("emp_Education_certificate <=", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateLike(String value) {
            addCriterion("emp_Education_certificate like", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateNotLike(String value) {
            addCriterion("emp_Education_certificate not like", value, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateIn(List<String> values) {
            addCriterion("emp_Education_certificate in", values, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateNotIn(List<String> values) {
            addCriterion("emp_Education_certificate not in", values, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateBetween(String value1, String value2) {
            addCriterion("emp_Education_certificate between", value1, value2, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpEducationCertificateNotBetween(String value1, String value2) {
            addCriterion("emp_Education_certificate not between", value1, value2, "empEducationCertificate");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathIsNull() {
            addCriterion("emp_technical_title_path is null");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathIsNotNull() {
            addCriterion("emp_technical_title_path is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathEqualTo(String value) {
            addCriterion("emp_technical_title_path =", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathNotEqualTo(String value) {
            addCriterion("emp_technical_title_path <>", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathGreaterThan(String value) {
            addCriterion("emp_technical_title_path >", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathGreaterThanOrEqualTo(String value) {
            addCriterion("emp_technical_title_path >=", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathLessThan(String value) {
            addCriterion("emp_technical_title_path <", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathLessThanOrEqualTo(String value) {
            addCriterion("emp_technical_title_path <=", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathLike(String value) {
            addCriterion("emp_technical_title_path like", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathNotLike(String value) {
            addCriterion("emp_technical_title_path not like", value, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathIn(List<String> values) {
            addCriterion("emp_technical_title_path in", values, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathNotIn(List<String> values) {
            addCriterion("emp_technical_title_path not in", values, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathBetween(String value1, String value2) {
            addCriterion("emp_technical_title_path between", value1, value2, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpTechnicalTitlePathNotBetween(String value1, String value2) {
            addCriterion("emp_technical_title_path not between", value1, value2, "empTechnicalTitlePath");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceIsNull() {
            addCriterion("emp_Education_experience is null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceIsNotNull() {
            addCriterion("emp_Education_experience is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceEqualTo(String value) {
            addCriterion("emp_Education_experience =", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceNotEqualTo(String value) {
            addCriterion("emp_Education_experience <>", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceGreaterThan(String value) {
            addCriterion("emp_Education_experience >", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("emp_Education_experience >=", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceLessThan(String value) {
            addCriterion("emp_Education_experience <", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceLessThanOrEqualTo(String value) {
            addCriterion("emp_Education_experience <=", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceLike(String value) {
            addCriterion("emp_Education_experience like", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceNotLike(String value) {
            addCriterion("emp_Education_experience not like", value, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceIn(List<String> values) {
            addCriterion("emp_Education_experience in", values, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceNotIn(List<String> values) {
            addCriterion("emp_Education_experience not in", values, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceBetween(String value1, String value2) {
            addCriterion("emp_Education_experience between", value1, value2, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpEducationExperienceNotBetween(String value1, String value2) {
            addCriterion("emp_Education_experience not between", value1, value2, "empEducationExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceIsNull() {
            addCriterion("emp_work_experience is null");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceIsNotNull() {
            addCriterion("emp_work_experience is not null");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceEqualTo(String value) {
            addCriterion("emp_work_experience =", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceNotEqualTo(String value) {
            addCriterion("emp_work_experience <>", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceGreaterThan(String value) {
            addCriterion("emp_work_experience >", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("emp_work_experience >=", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceLessThan(String value) {
            addCriterion("emp_work_experience <", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceLessThanOrEqualTo(String value) {
            addCriterion("emp_work_experience <=", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceLike(String value) {
            addCriterion("emp_work_experience like", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceNotLike(String value) {
            addCriterion("emp_work_experience not like", value, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceIn(List<String> values) {
            addCriterion("emp_work_experience in", values, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceNotIn(List<String> values) {
            addCriterion("emp_work_experience not in", values, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceBetween(String value1, String value2) {
            addCriterion("emp_work_experience between", value1, value2, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpWorkExperienceNotBetween(String value1, String value2) {
            addCriterion("emp_work_experience not between", value1, value2, "empWorkExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceIsNull() {
            addCriterion("emp_train_experience is null");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceIsNotNull() {
            addCriterion("emp_train_experience is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceEqualTo(String value) {
            addCriterion("emp_train_experience =", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceNotEqualTo(String value) {
            addCriterion("emp_train_experience <>", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceGreaterThan(String value) {
            addCriterion("emp_train_experience >", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("emp_train_experience >=", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceLessThan(String value) {
            addCriterion("emp_train_experience <", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceLessThanOrEqualTo(String value) {
            addCriterion("emp_train_experience <=", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceLike(String value) {
            addCriterion("emp_train_experience like", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceNotLike(String value) {
            addCriterion("emp_train_experience not like", value, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceIn(List<String> values) {
            addCriterion("emp_train_experience in", values, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceNotIn(List<String> values) {
            addCriterion("emp_train_experience not in", values, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceBetween(String value1, String value2) {
            addCriterion("emp_train_experience between", value1, value2, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpTrainExperienceNotBetween(String value1, String value2) {
            addCriterion("emp_train_experience not between", value1, value2, "empTrainExperience");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationIsNull() {
            addCriterion("emp_society_relation is null");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationIsNotNull() {
            addCriterion("emp_society_relation is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationEqualTo(String value) {
            addCriterion("emp_society_relation =", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationNotEqualTo(String value) {
            addCriterion("emp_society_relation <>", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationGreaterThan(String value) {
            addCriterion("emp_society_relation >", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationGreaterThanOrEqualTo(String value) {
            addCriterion("emp_society_relation >=", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationLessThan(String value) {
            addCriterion("emp_society_relation <", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationLessThanOrEqualTo(String value) {
            addCriterion("emp_society_relation <=", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationLike(String value) {
            addCriterion("emp_society_relation like", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationNotLike(String value) {
            addCriterion("emp_society_relation not like", value, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationIn(List<String> values) {
            addCriterion("emp_society_relation in", values, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationNotIn(List<String> values) {
            addCriterion("emp_society_relation not in", values, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationBetween(String value1, String value2) {
            addCriterion("emp_society_relation between", value1, value2, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpSocietyRelationNotBetween(String value1, String value2) {
            addCriterion("emp_society_relation not between", value1, value2, "empSocietyRelation");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksIsNull() {
            addCriterion("emp_remarks is null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksIsNotNull() {
            addCriterion("emp_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksEqualTo(String value) {
            addCriterion("emp_remarks =", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksNotEqualTo(String value) {
            addCriterion("emp_remarks <>", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksGreaterThan(String value) {
            addCriterion("emp_remarks >", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("emp_remarks >=", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksLessThan(String value) {
            addCriterion("emp_remarks <", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksLessThanOrEqualTo(String value) {
            addCriterion("emp_remarks <=", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksLike(String value) {
            addCriterion("emp_remarks like", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksNotLike(String value) {
            addCriterion("emp_remarks not like", value, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksIn(List<String> values) {
            addCriterion("emp_remarks in", values, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksNotIn(List<String> values) {
            addCriterion("emp_remarks not in", values, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksBetween(String value1, String value2) {
            addCriterion("emp_remarks between", value1, value2, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpRemarksNotBetween(String value1, String value2) {
            addCriterion("emp_remarks not between", value1, value2, "empRemarks");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusIsNull() {
            addCriterion("emp_delectStatus is null");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusIsNotNull() {
            addCriterion("emp_delectStatus is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusEqualTo(String value) {
            addCriterion("emp_delectStatus =", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusNotEqualTo(String value) {
            addCriterion("emp_delectStatus <>", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusGreaterThan(String value) {
            addCriterion("emp_delectStatus >", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusGreaterThanOrEqualTo(String value) {
            addCriterion("emp_delectStatus >=", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusLessThan(String value) {
            addCriterion("emp_delectStatus <", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusLessThanOrEqualTo(String value) {
            addCriterion("emp_delectStatus <=", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusLike(String value) {
            addCriterion("emp_delectStatus like", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusNotLike(String value) {
            addCriterion("emp_delectStatus not like", value, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusIn(List<String> values) {
            addCriterion("emp_delectStatus in", values, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusNotIn(List<String> values) {
            addCriterion("emp_delectStatus not in", values, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusBetween(String value1, String value2) {
            addCriterion("emp_delectStatus between", value1, value2, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDelectstatusNotBetween(String value1, String value2) {
            addCriterion("emp_delectStatus not between", value1, value2, "empDelectstatus");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentIsNull() {
            addCriterion("emp_department is null");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentIsNotNull() {
            addCriterion("emp_department is not null");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentEqualTo(Integer value) {
            addCriterion("emp_department =", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentNotEqualTo(Integer value) {
            addCriterion("emp_department <>", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentGreaterThan(Integer value) {
            addCriterion("emp_department >", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_department >=", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentLessThan(Integer value) {
            addCriterion("emp_department <", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentLessThanOrEqualTo(Integer value) {
            addCriterion("emp_department <=", value, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentIn(List<Integer> values) {
            addCriterion("emp_department in", values, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentNotIn(List<Integer> values) {
            addCriterion("emp_department not in", values, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentBetween(Integer value1, Integer value2) {
            addCriterion("emp_department between", value1, value2, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpDepartmentNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_department not between", value1, value2, "empDepartment");
            return (Criteria) this;
        }

        public Criteria andEmpPositionIsNull() {
            addCriterion("emp_position is null");
            return (Criteria) this;
        }

        public Criteria andEmpPositionIsNotNull() {
            addCriterion("emp_position is not null");
            return (Criteria) this;
        }

        public Criteria andEmpPositionEqualTo(Integer value) {
            addCriterion("emp_position =", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionNotEqualTo(Integer value) {
            addCriterion("emp_position <>", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionGreaterThan(Integer value) {
            addCriterion("emp_position >", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_position >=", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionLessThan(Integer value) {
            addCriterion("emp_position <", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionLessThanOrEqualTo(Integer value) {
            addCriterion("emp_position <=", value, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionIn(List<Integer> values) {
            addCriterion("emp_position in", values, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionNotIn(List<Integer> values) {
            addCriterion("emp_position not in", values, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionBetween(Integer value1, Integer value2) {
            addCriterion("emp_position between", value1, value2, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_position not between", value1, value2, "empPosition");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundIsNull() {
            addCriterion("emp_educational_background is null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundIsNotNull() {
            addCriterion("emp_educational_background is not null");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundEqualTo(String value) {
            addCriterion("emp_educational_background =", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundNotEqualTo(String value) {
            addCriterion("emp_educational_background <>", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundGreaterThan(String value) {
            addCriterion("emp_educational_background >", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("emp_educational_background >=", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundLessThan(String value) {
            addCriterion("emp_educational_background <", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundLessThanOrEqualTo(String value) {
            addCriterion("emp_educational_background <=", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundLike(String value) {
            addCriterion("emp_educational_background like", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundNotLike(String value) {
            addCriterion("emp_educational_background not like", value, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundIn(List<String> values) {
            addCriterion("emp_educational_background in", values, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundNotIn(List<String> values) {
            addCriterion("emp_educational_background not in", values, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundBetween(String value1, String value2) {
            addCriterion("emp_educational_background between", value1, value2, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpEducationalBackgroundNotBetween(String value1, String value2) {
            addCriterion("emp_educational_background not between", value1, value2, "empEducationalBackground");
            return (Criteria) this;
        }

        public Criteria andEmpAgeIsNull() {
            addCriterion("emp_age is null");
            return (Criteria) this;
        }

        public Criteria andEmpAgeIsNotNull() {
            addCriterion("emp_age is not null");
            return (Criteria) this;
        }

        public Criteria andEmpAgeEqualTo(Integer value) {
            addCriterion("emp_age =", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeNotEqualTo(Integer value) {
            addCriterion("emp_age <>", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeGreaterThan(Integer value) {
            addCriterion("emp_age >", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_age >=", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeLessThan(Integer value) {
            addCriterion("emp_age <", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeLessThanOrEqualTo(Integer value) {
            addCriterion("emp_age <=", value, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeIn(List<Integer> values) {
            addCriterion("emp_age in", values, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeNotIn(List<Integer> values) {
            addCriterion("emp_age not in", values, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeBetween(Integer value1, Integer value2) {
            addCriterion("emp_age between", value1, value2, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_age not between", value1, value2, "empAge");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNull() {
            addCriterion("emp_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNotNull() {
            addCriterion("emp_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayEqualTo(Date value) {
            addCriterion("emp_birthday =", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotEqualTo(Date value) {
            addCriterion("emp_birthday <>", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThan(Date value) {
            addCriterion("emp_birthday >", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("emp_birthday >=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThan(Date value) {
            addCriterion("emp_birthday <", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("emp_birthday <=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIn(List<Date> values) {
            addCriterion("emp_birthday in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotIn(List<Date> values) {
            addCriterion("emp_birthday not in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayBetween(Date value1, Date value2) {
            addCriterion("emp_birthday between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("emp_birthday not between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailIsNull() {
            addCriterion("emp_origin_detail is null");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailIsNotNull() {
            addCriterion("emp_origin_detail is not null");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailEqualTo(String value) {
            addCriterion("emp_origin_detail =", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailNotEqualTo(String value) {
            addCriterion("emp_origin_detail <>", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailGreaterThan(String value) {
            addCriterion("emp_origin_detail >", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_origin_detail >=", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailLessThan(String value) {
            addCriterion("emp_origin_detail <", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailLessThanOrEqualTo(String value) {
            addCriterion("emp_origin_detail <=", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailLike(String value) {
            addCriterion("emp_origin_detail like", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailNotLike(String value) {
            addCriterion("emp_origin_detail not like", value, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailIn(List<String> values) {
            addCriterion("emp_origin_detail in", values, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailNotIn(List<String> values) {
            addCriterion("emp_origin_detail not in", values, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailBetween(String value1, String value2) {
            addCriterion("emp_origin_detail between", value1, value2, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpOriginDetailNotBetween(String value1, String value2) {
            addCriterion("emp_origin_detail not between", value1, value2, "empOriginDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceIsNull() {
            addCriterion("emp_now_province is null");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceIsNotNull() {
            addCriterion("emp_now_province is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceEqualTo(String value) {
            addCriterion("emp_now_province =", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceNotEqualTo(String value) {
            addCriterion("emp_now_province <>", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceGreaterThan(String value) {
            addCriterion("emp_now_province >", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("emp_now_province >=", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceLessThan(String value) {
            addCriterion("emp_now_province <", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceLessThanOrEqualTo(String value) {
            addCriterion("emp_now_province <=", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceLike(String value) {
            addCriterion("emp_now_province like", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceNotLike(String value) {
            addCriterion("emp_now_province not like", value, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceIn(List<String> values) {
            addCriterion("emp_now_province in", values, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceNotIn(List<String> values) {
            addCriterion("emp_now_province not in", values, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceBetween(String value1, String value2) {
            addCriterion("emp_now_province between", value1, value2, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowProvinceNotBetween(String value1, String value2) {
            addCriterion("emp_now_province not between", value1, value2, "empNowProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityIsNull() {
            addCriterion("emp_now_city is null");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityIsNotNull() {
            addCriterion("emp_now_city is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityEqualTo(String value) {
            addCriterion("emp_now_city =", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityNotEqualTo(String value) {
            addCriterion("emp_now_city <>", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityGreaterThan(String value) {
            addCriterion("emp_now_city >", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityGreaterThanOrEqualTo(String value) {
            addCriterion("emp_now_city >=", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityLessThan(String value) {
            addCriterion("emp_now_city <", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityLessThanOrEqualTo(String value) {
            addCriterion("emp_now_city <=", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityLike(String value) {
            addCriterion("emp_now_city like", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityNotLike(String value) {
            addCriterion("emp_now_city not like", value, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityIn(List<String> values) {
            addCriterion("emp_now_city in", values, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityNotIn(List<String> values) {
            addCriterion("emp_now_city not in", values, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityBetween(String value1, String value2) {
            addCriterion("emp_now_city between", value1, value2, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCityNotBetween(String value1, String value2) {
            addCriterion("emp_now_city not between", value1, value2, "empNowCity");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyIsNull() {
            addCriterion("emp_now_county is null");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyIsNotNull() {
            addCriterion("emp_now_county is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyEqualTo(String value) {
            addCriterion("emp_now_county =", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyNotEqualTo(String value) {
            addCriterion("emp_now_county <>", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyGreaterThan(String value) {
            addCriterion("emp_now_county >", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyGreaterThanOrEqualTo(String value) {
            addCriterion("emp_now_county >=", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyLessThan(String value) {
            addCriterion("emp_now_county <", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyLessThanOrEqualTo(String value) {
            addCriterion("emp_now_county <=", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyLike(String value) {
            addCriterion("emp_now_county like", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyNotLike(String value) {
            addCriterion("emp_now_county not like", value, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyIn(List<String> values) {
            addCriterion("emp_now_county in", values, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyNotIn(List<String> values) {
            addCriterion("emp_now_county not in", values, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyBetween(String value1, String value2) {
            addCriterion("emp_now_county between", value1, value2, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowCountyNotBetween(String value1, String value2) {
            addCriterion("emp_now_county not between", value1, value2, "empNowCounty");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailIsNull() {
            addCriterion("emp_now_detail is null");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailIsNotNull() {
            addCriterion("emp_now_detail is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailEqualTo(String value) {
            addCriterion("emp_now_detail =", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailNotEqualTo(String value) {
            addCriterion("emp_now_detail <>", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailGreaterThan(String value) {
            addCriterion("emp_now_detail >", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_now_detail >=", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailLessThan(String value) {
            addCriterion("emp_now_detail <", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailLessThanOrEqualTo(String value) {
            addCriterion("emp_now_detail <=", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailLike(String value) {
            addCriterion("emp_now_detail like", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailNotLike(String value) {
            addCriterion("emp_now_detail not like", value, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailIn(List<String> values) {
            addCriterion("emp_now_detail in", values, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailNotIn(List<String> values) {
            addCriterion("emp_now_detail not in", values, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailBetween(String value1, String value2) {
            addCriterion("emp_now_detail between", value1, value2, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpNowDetailNotBetween(String value1, String value2) {
            addCriterion("emp_now_detail not between", value1, value2, "empNowDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceIsNull() {
            addCriterion("emp_contact_address_province is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceIsNotNull() {
            addCriterion("emp_contact_address_province is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceEqualTo(String value) {
            addCriterion("emp_contact_address_province =", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceNotEqualTo(String value) {
            addCriterion("emp_contact_address_province <>", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceGreaterThan(String value) {
            addCriterion("emp_contact_address_province >", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_province >=", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceLessThan(String value) {
            addCriterion("emp_contact_address_province <", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_province <=", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceLike(String value) {
            addCriterion("emp_contact_address_province like", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceNotLike(String value) {
            addCriterion("emp_contact_address_province not like", value, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceIn(List<String> values) {
            addCriterion("emp_contact_address_province in", values, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceNotIn(List<String> values) {
            addCriterion("emp_contact_address_province not in", values, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceBetween(String value1, String value2) {
            addCriterion("emp_contact_address_province between", value1, value2, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressProvinceNotBetween(String value1, String value2) {
            addCriterion("emp_contact_address_province not between", value1, value2, "empContactAddressProvince");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityIsNull() {
            addCriterion("emp_contact_address_city is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityIsNotNull() {
            addCriterion("emp_contact_address_city is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityEqualTo(String value) {
            addCriterion("emp_contact_address_city =", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityNotEqualTo(String value) {
            addCriterion("emp_contact_address_city <>", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityGreaterThan(String value) {
            addCriterion("emp_contact_address_city >", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_city >=", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityLessThan(String value) {
            addCriterion("emp_contact_address_city <", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_city <=", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityLike(String value) {
            addCriterion("emp_contact_address_city like", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityNotLike(String value) {
            addCriterion("emp_contact_address_city not like", value, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityIn(List<String> values) {
            addCriterion("emp_contact_address_city in", values, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityNotIn(List<String> values) {
            addCriterion("emp_contact_address_city not in", values, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityBetween(String value1, String value2) {
            addCriterion("emp_contact_address_city between", value1, value2, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCityNotBetween(String value1, String value2) {
            addCriterion("emp_contact_address_city not between", value1, value2, "empContactAddressCity");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyIsNull() {
            addCriterion("emp_contact_address_county is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyIsNotNull() {
            addCriterion("emp_contact_address_county is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyEqualTo(String value) {
            addCriterion("emp_contact_address_county =", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyNotEqualTo(String value) {
            addCriterion("emp_contact_address_county <>", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyGreaterThan(String value) {
            addCriterion("emp_contact_address_county >", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_county >=", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyLessThan(String value) {
            addCriterion("emp_contact_address_county <", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_county <=", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyLike(String value) {
            addCriterion("emp_contact_address_county like", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyNotLike(String value) {
            addCriterion("emp_contact_address_county not like", value, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyIn(List<String> values) {
            addCriterion("emp_contact_address_county in", values, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyNotIn(List<String> values) {
            addCriterion("emp_contact_address_county not in", values, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyBetween(String value1, String value2) {
            addCriterion("emp_contact_address_county between", value1, value2, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressCountyNotBetween(String value1, String value2) {
            addCriterion("emp_contact_address_county not between", value1, value2, "empContactAddressCounty");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailIsNull() {
            addCriterion("emp_contact_address_detail is null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailIsNotNull() {
            addCriterion("emp_contact_address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailEqualTo(String value) {
            addCriterion("emp_contact_address_detail =", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailNotEqualTo(String value) {
            addCriterion("emp_contact_address_detail <>", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailGreaterThan(String value) {
            addCriterion("emp_contact_address_detail >", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_detail >=", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailLessThan(String value) {
            addCriterion("emp_contact_address_detail <", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("emp_contact_address_detail <=", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailLike(String value) {
            addCriterion("emp_contact_address_detail like", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailNotLike(String value) {
            addCriterion("emp_contact_address_detail not like", value, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailIn(List<String> values) {
            addCriterion("emp_contact_address_detail in", values, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailNotIn(List<String> values) {
            addCriterion("emp_contact_address_detail not in", values, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailBetween(String value1, String value2) {
            addCriterion("emp_contact_address_detail between", value1, value2, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andEmpContactAddressDetailNotBetween(String value1, String value2) {
            addCriterion("emp_contact_address_detail not between", value1, value2, "empContactAddressDetail");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
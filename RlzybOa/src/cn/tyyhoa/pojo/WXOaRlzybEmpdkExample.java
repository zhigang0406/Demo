package cn.tyyhoa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WXOaRlzybEmpdkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WXOaRlzybEmpdkExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empId is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empId is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empId =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empId <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empId >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empId >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empId <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empId <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empId in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empId not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empId between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empId not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andStatusAmIsNull() {
            addCriterion("status_am is null");
            return (Criteria) this;
        }

        public Criteria andStatusAmIsNotNull() {
            addCriterion("status_am is not null");
            return (Criteria) this;
        }

        public Criteria andStatusAmEqualTo(Integer value) {
            addCriterion("status_am =", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmNotEqualTo(Integer value) {
            addCriterion("status_am <>", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmGreaterThan(Integer value) {
            addCriterion("status_am >", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_am >=", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmLessThan(Integer value) {
            addCriterion("status_am <", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmLessThanOrEqualTo(Integer value) {
            addCriterion("status_am <=", value, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmIn(List<Integer> values) {
            addCriterion("status_am in", values, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmNotIn(List<Integer> values) {
            addCriterion("status_am not in", values, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmBetween(Integer value1, Integer value2) {
            addCriterion("status_am between", value1, value2, "statusAm");
            return (Criteria) this;
        }

        public Criteria andStatusAmNotBetween(Integer value1, Integer value2) {
            addCriterion("status_am not between", value1, value2, "statusAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmIsNull() {
            addCriterion("time_am is null");
            return (Criteria) this;
        }

        public Criteria andTimeAmIsNotNull() {
            addCriterion("time_am is not null");
            return (Criteria) this;
        }

        public Criteria andTimeAmEqualTo(Date value) {
            addCriterion("time_am =", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmNotEqualTo(Date value) {
            addCriterion("time_am <>", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmGreaterThan(Date value) {
            addCriterion("time_am >", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmGreaterThanOrEqualTo(Date value) {
            addCriterion("time_am >=", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmLessThan(Date value) {
            addCriterion("time_am <", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmLessThanOrEqualTo(Date value) {
            addCriterion("time_am <=", value, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmIn(List<Date> values) {
            addCriterion("time_am in", values, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmNotIn(List<Date> values) {
            addCriterion("time_am not in", values, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmBetween(Date value1, Date value2) {
            addCriterion("time_am between", value1, value2, "timeAm");
            return (Criteria) this;
        }

        public Criteria andTimeAmNotBetween(Date value1, Date value2) {
            addCriterion("time_am not between", value1, value2, "timeAm");
            return (Criteria) this;
        }

        public Criteria andStatusPmIsNull() {
            addCriterion("status_pm is null");
            return (Criteria) this;
        }

        public Criteria andStatusPmIsNotNull() {
            addCriterion("status_pm is not null");
            return (Criteria) this;
        }

        public Criteria andStatusPmEqualTo(Integer value) {
            addCriterion("status_pm =", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmNotEqualTo(Integer value) {
            addCriterion("status_pm <>", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmGreaterThan(Integer value) {
            addCriterion("status_pm >", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmGreaterThanOrEqualTo(Integer value) {
            addCriterion("status_pm >=", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmLessThan(Integer value) {
            addCriterion("status_pm <", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmLessThanOrEqualTo(Integer value) {
            addCriterion("status_pm <=", value, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmIn(List<Integer> values) {
            addCriterion("status_pm in", values, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmNotIn(List<Integer> values) {
            addCriterion("status_pm not in", values, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmBetween(Integer value1, Integer value2) {
            addCriterion("status_pm between", value1, value2, "statusPm");
            return (Criteria) this;
        }

        public Criteria andStatusPmNotBetween(Integer value1, Integer value2) {
            addCriterion("status_pm not between", value1, value2, "statusPm");
            return (Criteria) this;
        }

        public Criteria andTimePmIsNull() {
            addCriterion("time_pm is null");
            return (Criteria) this;
        }

        public Criteria andTimePmIsNotNull() {
            addCriterion("time_pm is not null");
            return (Criteria) this;
        }

        public Criteria andTimePmEqualTo(Date value) {
            addCriterion("time_pm =", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmNotEqualTo(Date value) {
            addCriterion("time_pm <>", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmGreaterThan(Date value) {
            addCriterion("time_pm >", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmGreaterThanOrEqualTo(Date value) {
            addCriterion("time_pm >=", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmLessThan(Date value) {
            addCriterion("time_pm <", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmLessThanOrEqualTo(Date value) {
            addCriterion("time_pm <=", value, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmIn(List<Date> values) {
            addCriterion("time_pm in", values, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmNotIn(List<Date> values) {
            addCriterion("time_pm not in", values, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmBetween(Date value1, Date value2) {
            addCriterion("time_pm between", value1, value2, "timePm");
            return (Criteria) this;
        }

        public Criteria andTimePmNotBetween(Date value1, Date value2) {
            addCriterion("time_pm not between", value1, value2, "timePm");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andHoursIsNull() {
            addCriterion("hours is null");
            return (Criteria) this;
        }

        public Criteria andHoursIsNotNull() {
            addCriterion("hours is not null");
            return (Criteria) this;
        }

        public Criteria andHoursEqualTo(Integer value) {
            addCriterion("hours =", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotEqualTo(Integer value) {
            addCriterion("hours <>", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThan(Integer value) {
            addCriterion("hours >", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThanOrEqualTo(Integer value) {
            addCriterion("hours >=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThan(Integer value) {
            addCriterion("hours <", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThanOrEqualTo(Integer value) {
            addCriterion("hours <=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursIn(List<Integer> values) {
            addCriterion("hours in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotIn(List<Integer> values) {
            addCriterion("hours not in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursBetween(Integer value1, Integer value2) {
            addCriterion("hours between", value1, value2, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotBetween(Integer value1, Integer value2) {
            addCriterion("hours not between", value1, value2, "hours");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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
package com.card.management.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MBatchNumberExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public MBatchNumberExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

		public Criteria andBatchNumberIsNull() {
			addCriterion("batch_number is null");
			return (Criteria) this;
		}

		public Criteria andBatchNumberIsNotNull() {
			addCriterion("batch_number is not null");
			return (Criteria) this;
		}

		public Criteria andBatchNumberEqualTo(String value) {
			addCriterion("batch_number =", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberNotEqualTo(String value) {
			addCriterion("batch_number <>", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberGreaterThan(String value) {
			addCriterion("batch_number >", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
			addCriterion("batch_number >=", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberLessThan(String value) {
			addCriterion("batch_number <", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberLessThanOrEqualTo(String value) {
			addCriterion("batch_number <=", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberLike(String value) {
			addCriterion("batch_number like", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberNotLike(String value) {
			addCriterion("batch_number not like", value, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberIn(List<String> values) {
			addCriterion("batch_number in", values, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberNotIn(List<String> values) {
			addCriterion("batch_number not in", values, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberBetween(String value1, String value2) {
			addCriterion("batch_number between", value1, value2, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andBatchNumberNotBetween(String value1, String value2) {
			addCriterion("batch_number not between", value1, value2, "batchNumber");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameIsNull() {
			addCriterion("machine_category_name is null");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameIsNotNull() {
			addCriterion("machine_category_name is not null");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameEqualTo(String value) {
			addCriterion("machine_category_name =", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameNotEqualTo(String value) {
			addCriterion("machine_category_name <>", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameGreaterThan(String value) {
			addCriterion("machine_category_name >", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameGreaterThanOrEqualTo(String value) {
			addCriterion("machine_category_name >=", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameLessThan(String value) {
			addCriterion("machine_category_name <", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameLessThanOrEqualTo(String value) {
			addCriterion("machine_category_name <=", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameLike(String value) {
			addCriterion("machine_category_name like", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameNotLike(String value) {
			addCriterion("machine_category_name not like", value, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameIn(List<String> values) {
			addCriterion("machine_category_name in", values, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameNotIn(List<String> values) {
			addCriterion("machine_category_name not in", values, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameBetween(String value1, String value2) {
			addCriterion("machine_category_name between", value1, value2, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCategoryNameNotBetween(String value1, String value2) {
			addCriterion("machine_category_name not between", value1, value2, "machineCategoryName");
			return (Criteria) this;
		}

		public Criteria andMachineCountIsNull() {
			addCriterion("machine_count is null");
			return (Criteria) this;
		}

		public Criteria andMachineCountIsNotNull() {
			addCriterion("machine_count is not null");
			return (Criteria) this;
		}

		public Criteria andMachineCountEqualTo(Byte value) {
			addCriterion("machine_count =", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountNotEqualTo(Byte value) {
			addCriterion("machine_count <>", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountGreaterThan(Byte value) {
			addCriterion("machine_count >", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountGreaterThanOrEqualTo(Byte value) {
			addCriterion("machine_count >=", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountLessThan(Byte value) {
			addCriterion("machine_count <", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountLessThanOrEqualTo(Byte value) {
			addCriterion("machine_count <=", value, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountIn(List<Byte> values) {
			addCriterion("machine_count in", values, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountNotIn(List<Byte> values) {
			addCriterion("machine_count not in", values, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountBetween(Byte value1, Byte value2) {
			addCriterion("machine_count between", value1, value2, "machineCount");
			return (Criteria) this;
		}

		public Criteria andMachineCountNotBetween(Byte value1, Byte value2) {
			addCriterion("machine_count not between", value1, value2, "machineCount");
			return (Criteria) this;
		}

		public Criteria andCarCountIsNull() {
			addCriterion("car_count is null");
			return (Criteria) this;
		}

		public Criteria andCarCountIsNotNull() {
			addCriterion("car_count is not null");
			return (Criteria) this;
		}

		public Criteria andCarCountEqualTo(Byte value) {
			addCriterion("car_count =", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountNotEqualTo(Byte value) {
			addCriterion("car_count <>", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountGreaterThan(Byte value) {
			addCriterion("car_count >", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountGreaterThanOrEqualTo(Byte value) {
			addCriterion("car_count >=", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountLessThan(Byte value) {
			addCriterion("car_count <", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountLessThanOrEqualTo(Byte value) {
			addCriterion("car_count <=", value, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountIn(List<Byte> values) {
			addCriterion("car_count in", values, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountNotIn(List<Byte> values) {
			addCriterion("car_count not in", values, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountBetween(Byte value1, Byte value2) {
			addCriterion("car_count between", value1, value2, "carCount");
			return (Criteria) this;
		}

		public Criteria andCarCountNotBetween(Byte value1, Byte value2) {
			addCriterion("car_count not between", value1, value2, "carCount");
			return (Criteria) this;
		}

		public Criteria andWriteDateIsNull() {
			addCriterion("write_date is null");
			return (Criteria) this;
		}

		public Criteria andWriteDateIsNotNull() {
			addCriterion("write_date is not null");
			return (Criteria) this;
		}

		public Criteria andWriteDateEqualTo(Date value) {
			addCriterionForJDBCDate("write_date =", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("write_date <>", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateGreaterThan(Date value) {
			addCriterionForJDBCDate("write_date >", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("write_date >=", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateLessThan(Date value) {
			addCriterionForJDBCDate("write_date <", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("write_date <=", value, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateIn(List<Date> values) {
			addCriterionForJDBCDate("write_date in", values, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("write_date not in", values, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("write_date between", value1, value2, "writeDate");
			return (Criteria) this;
		}

		public Criteria andWriteDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("write_date not between", value1, value2, "writeDate");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNull() {
			addCriterion("delete_flg is null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIsNotNull() {
			addCriterion("delete_flg is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgEqualTo(String value) {
			addCriterion("delete_flg =", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotEqualTo(String value) {
			addCriterion("delete_flg <>", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThan(String value) {
			addCriterion("delete_flg >", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgGreaterThanOrEqualTo(String value) {
			addCriterion("delete_flg >=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThan(String value) {
			addCriterion("delete_flg <", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLessThanOrEqualTo(String value) {
			addCriterion("delete_flg <=", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgLike(String value) {
			addCriterion("delete_flg like", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotLike(String value) {
			addCriterion("delete_flg not like", value, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgIn(List<String> values) {
			addCriterion("delete_flg in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotIn(List<String> values) {
			addCriterion("delete_flg not in", values, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgBetween(String value1, String value2) {
			addCriterion("delete_flg between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andDeleteFlgNotBetween(String value1, String value2) {
			addCriterion("delete_flg not between", value1, value2, "deleteFlg");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table m_batch_number
	 * @mbg.generated  Thu Feb 29 20:48:52 CST 2024
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_batch_number
     *
     * @mbg.generated do_not_delete_during_merge Thu Feb 29 20:48:52 CST 2024
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}
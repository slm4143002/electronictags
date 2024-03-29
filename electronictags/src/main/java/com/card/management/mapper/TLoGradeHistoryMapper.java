package com.card.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.card.management.entity.TLoGradeHistory;
import com.card.management.entity.TLoGradeHistoryExample;

@Mapper
public interface TLoGradeHistoryMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	long countByExample(TLoGradeHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int deleteByExample(TLoGradeHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int insert(TLoGradeHistory row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int insertSelective(TLoGradeHistory row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	List<TLoGradeHistory> selectByExample(TLoGradeHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	TLoGradeHistory selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int updateByExampleSelective(@Param("row") TLoGradeHistory row, @Param("example") TLoGradeHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int updateByExample(@Param("row") TLoGradeHistory row, @Param("example") TLoGradeHistoryExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int updateByPrimaryKeySelective(TLoGradeHistory row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_lo_grade_history
	 * @mbg.generated  Sat Mar 09 16:26:40 CST 2024
	 */
	int updateByPrimaryKey(TLoGradeHistory row);
}
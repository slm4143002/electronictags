package com.card.management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.card.management.entity.TWarningMessage;
import com.card.management.entity.TWarningMessageExample;

@Mapper
public interface TWarningMessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    long countByExample(TWarningMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int deleteByExample(TWarningMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int insert(TWarningMessage row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int insertSelective(TWarningMessage row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    List<TWarningMessage> selectByExample(TWarningMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    TWarningMessage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int updateByExampleSelective(@Param("row") TWarningMessage row, @Param("example") TWarningMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int updateByExample(@Param("row") TWarningMessage row, @Param("example") TWarningMessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int updateByPrimaryKeySelective(TWarningMessage row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_warning_message
     *
     * @mbg.generated Sun Mar 10 14:50:42 CST 2024
     */
    int updateByPrimaryKey(TWarningMessage row);
}
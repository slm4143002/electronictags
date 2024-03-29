package com.card.management.entity;

import java.util.Date;

public class TAssembleDetail {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.id
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private Integer id;
	
	private int pieceTimes;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.batch_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String batchNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.write_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private Date writeDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.card_binding_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String cardBindingNumber;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.ticket_info
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String ticketInfo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.assemble_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String assembleResult;
	private String assembleResultLo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.ground_connection_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String groundConnectionResult;
	private String groundConnectionResultLo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.withstand_voltage_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String withstandVoltageResult;
	private String withstandVoltageResultLo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.ut_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private String utResult;
	private String utResultLo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.update_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private Date updateDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_assemble_detail.create_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	private Date createDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.id
	 * @return  the value of t_assemble_detail.id
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.id
	 * @param id  the value for t_assemble_detail.id
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.batch_number
	 * @return  the value of t_assemble_detail.batch_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getBatchNumber() {
		return batchNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.batch_number
	 * @param batchNumber  the value for t_assemble_detail.batch_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber == null ? null : batchNumber.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.write_date
	 * @return  the value of t_assemble_detail.write_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public Date getWriteDate() {
		return writeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.write_date
	 * @param writeDate  the value for t_assemble_detail.write_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.card_binding_number
	 * @return  the value of t_assemble_detail.card_binding_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getCardBindingNumber() {
		return cardBindingNumber;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.card_binding_number
	 * @param cardBindingNumber  the value for t_assemble_detail.card_binding_number
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setCardBindingNumber(String cardBindingNumber) {
		this.cardBindingNumber = cardBindingNumber == null ? null : cardBindingNumber.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.ticket_info
	 * @return  the value of t_assemble_detail.ticket_info
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getTicketInfo() {
		return ticketInfo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.ticket_info
	 * @param ticketInfo  the value for t_assemble_detail.ticket_info
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo == null ? null : ticketInfo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.assemble_result
	 * @return  the value of t_assemble_detail.assemble_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getAssembleResult() {
		return assembleResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.assemble_result
	 * @param assembleResult  the value for t_assemble_detail.assemble_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setAssembleResult(String assembleResult) {
		this.assembleResult = assembleResult == null ? null : assembleResult.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.ground_connection_result
	 * @return  the value of t_assemble_detail.ground_connection_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getGroundConnectionResult() {
		return groundConnectionResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.ground_connection_result
	 * @param groundConnectionResult  the value for t_assemble_detail.ground_connection_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setGroundConnectionResult(String groundConnectionResult) {
		this.groundConnectionResult = groundConnectionResult == null ? null : groundConnectionResult.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.withstand_voltage_result
	 * @return  the value of t_assemble_detail.withstand_voltage_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getWithstandVoltageResult() {
		return withstandVoltageResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.withstand_voltage_result
	 * @param withstandVoltageResult  the value for t_assemble_detail.withstand_voltage_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setWithstandVoltageResult(String withstandVoltageResult) {
		this.withstandVoltageResult = withstandVoltageResult == null ? null : withstandVoltageResult.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.ut_result
	 * @return  the value of t_assemble_detail.ut_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public String getUtResult() {
		return utResult;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.ut_result
	 * @param utResult  the value for t_assemble_detail.ut_result
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setUtResult(String utResult) {
		this.utResult = utResult == null ? null : utResult.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.update_date
	 * @return  the value of t_assemble_detail.update_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.update_date
	 * @param updateDate  the value for t_assemble_detail.update_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_assemble_detail.create_date
	 * @return  the value of t_assemble_detail.create_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_assemble_detail.create_date
	 * @param createDate  the value for t_assemble_detail.create_date
	 * @mbg.generated  Sat Mar 09 12:18:20 CST 2024
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public int getPieceTimes() {
		return pieceTimes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_preparatory_detail.car_times
	 * @param carTimes  the value for t_preparatory_detail.car_times
	 * @mbg.generated  Sat Mar 09 08:43:52 CST 2024
	 */
	public void setPieceTimes(int pieceTimes) {
		this.pieceTimes = pieceTimes;
	}
	
	
	public String getAssembleResultLo() {
        return assembleResultLo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_assemble_detail.assemble_result_lo
     *
     * @param assembleResultLo the value for t_assemble_detail.assemble_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public void setAssembleResultLo(String assembleResultLo) {
        this.assembleResultLo = assembleResultLo;
    }
	
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_assemble_detail.ground_connection_result_lo
     *
     * @return the value of t_assemble_detail.ground_connection_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public String getGroundConnectionResultLo() {
        return groundConnectionResultLo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_assemble_detail.ground_connection_result_lo
     *
     * @param groundConnectionResultLo the value for t_assemble_detail.ground_connection_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public void setGroundConnectionResultLo(String groundConnectionResultLo) {
        this.groundConnectionResultLo = groundConnectionResultLo;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_assemble_detail.withstand_voltage_result_lo
     *
     * @return the value of t_assemble_detail.withstand_voltage_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public String getWithstandVoltageResultLo() {
        return withstandVoltageResultLo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_assemble_detail.withstand_voltage_result_lo
     *
     * @param withstandVoltageResultLo the value for t_assemble_detail.withstand_voltage_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public void setWithstandVoltageResultLo(String withstandVoltageResultLo) {
        this.withstandVoltageResultLo = withstandVoltageResultLo;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_assemble_detail.ut_result_lo
     *
     * @return the value of t_assemble_detail.ut_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public String getUtResultLo() {
        return utResultLo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_assemble_detail.ut_result_lo
     *
     * @param utResultLo the value for t_assemble_detail.ut_result_lo
     *
     * @mbg.generated Thu Mar 21 16:48:29 CST 2024
     */
    public void setUtResultLo(String utResultLo) {
        this.utResultLo = utResultLo;
    }
}
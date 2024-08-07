/**
 * 
 */
package com.card.management.service;

import java.util.List;

import com.card.management.entity.AssembleDetailEntity;
import com.card.management.entity.MBatchNumber;
import com.card.management.entity.PreparatoryDetailEntity;
import com.card.management.entity.TAssembleDetail;
import com.card.management.entity.TBatchProcessResultConfirm;
import com.card.management.entity.TLoGradeHistory;
import com.card.management.entity.TPreparatoryDetail;
import com.card.management.entity.TWarningMessage;

/**
 * @author slm
 *
 */
public interface CardInfoManagementService {

	// 取得批量号信息
	public MBatchNumber getCards(String batchNumber);

	// 取得筹备详细信息
	public int getPreparatoryDetailCount(String batchNumber);

	public List<PreparatoryDetailEntity> getPreparatoryDetailBybatchNumber(String batchNumber);
	
	// 更新筹备
	public void clearPreparatoryDetail(List<String> clearAssembleDetailList);

	// 取得组装明细详细信息
	public int getAssembleDetailCount(String batchNumber,String cardBindingNumber);
	public int getDetailCount(String batchNumber);

	public List<AssembleDetailEntity> getAssembleDetailBybatchNumber(String batchNumber);

	// L/O品履历信息登录
	public void insertHistory(TLoGradeHistory history);
	
	// 取得L/O品履历信息
	public int getLoGradeHistoryCount();

	public List<TLoGradeHistory> getLoGradeHistory();

	// 登录批量信息和筹备明细信息
	public long createBatchNumberPreparatoryDetail(
			List<TPreparatoryDetail> preparatoryDetailEntityList);
	
	// 登录批量信息和组装明细信息
	public long createAssemblDdetail(TAssembleDetail assembleDetail);
	
	// 取得警告信息
	public List<TWarningMessage> getWaringMessage();
	
	// 更新组装
	public void updateAssemblDdetail(TAssembleDetail assembleDetail);
	
	public void clearAssembleDetail(List<String> clearAssembleDetailList);
	
	public List<TAssembleDetail> getBatchNumberBybingNumber(String cardBindingNumber);
	public List<TAssembleDetail> getBatchNumberByTicketInfo(String ticketInfo);
	
	
	// 处理结果登录
	public void insertBatchProcessResultConfirm(TBatchProcessResultConfirm history);
	
	// 取得处理结果信息
	public  List<TBatchProcessResultConfirm> getBatchProcessResultConfirm(String batchNumber);
	// 更新处理结果信息
	public void updateBatchProcessResultConfirm(TBatchProcessResultConfirm history);
	
	// check水墨屏是否已经被使用
	public List<AssembleDetailEntity> checkAssembleBinNumber(List<String> bingNumberList);
	public List<PreparatoryDetailEntity> checkPreparatoryBinNumber(List<String> bingNumberList);

}

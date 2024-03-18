/**
 * 
 */
package com.card.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.StringUtils;

import com.card.management.entity.AssembleDetailEntity;
import com.card.management.entity.MBatchNumber;
import com.card.management.entity.MBatchNumberExample;
import com.card.management.entity.PreparatoryDetailEntity;
import com.card.management.entity.TAssembleDetail;
import com.card.management.entity.TAssembleDetailExample;
import com.card.management.entity.TLoGradeHistory;
import com.card.management.entity.TLoGradeHistoryExample;
import com.card.management.entity.TPreparatoryDetail;
import com.card.management.entity.TWarningMessage;
import com.card.management.entity.TWarningMessageExample;
import com.card.management.mapper.MBatchNumberMapper;
import com.card.management.mapper.TAssembleDetailMapper;
import com.card.management.mapper.TLoGradeHistoryMapper;
import com.card.management.mapper.TPreparatoryDetailMapper;
import com.card.management.mapper.TWarningMessageMapper;

/**
 * @author slm
 *
 */
@Service
public class CardInfoManagementServiceImpl implements CardInfoManagementService {

	@Autowired
	private MBatchNumberMapper mBatchNumberMapper;

	@Autowired
	private TPreparatoryDetailMapper tPreparatoryDetailMapper;

	@Autowired
	private TAssembleDetailMapper tAssembleDetailMapper;

	@Autowired
	private TLoGradeHistoryMapper tLoGradeHistoryMapper;
	
	@Autowired
	private TWarningMessageMapper tWarningMessageMapper;


	@Override
	public MBatchNumber getCards(String batchNumber) {
		MBatchNumberExample example = new MBatchNumberExample();
		example.createCriteria().andBatchNumberEqualTo(batchNumber);
		List<MBatchNumber> mn = this.mBatchNumberMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(mn)) {
			return null;
		}
		return mn.get(0);
	}

	@Override
	public int getPreparatoryDetailCount(String batchNumber) {
		if (StringUtils.isEmptyOrWhitespace(batchNumber)) {
			batchNumber = null;
		}
		long count = this.tPreparatoryDetailMapper.selectPreparatoryDetailCount(batchNumber);
		return (int) count;
	}

	@Override
	public List<PreparatoryDetailEntity> getPreparatoryDetailBybatchNumber(String batchNumber) {
		if (StringUtils.isEmptyOrWhitespace(batchNumber)) {
			batchNumber = null;
		}
		List<PreparatoryDetailEntity> preparatoryDetailEntityList = this.tPreparatoryDetailMapper
				.selectPreparatoryDetailBybatchNumber(batchNumber);
		return preparatoryDetailEntityList;
	}

	@Override
	public int getAssembleDetailCount(String batchNumber,String cardBindingNumber) {
		if (StringUtils.isEmptyOrWhitespace(batchNumber)) {
			batchNumber = null;
		}
		if (StringUtils.isEmptyOrWhitespace(cardBindingNumber)) {
			cardBindingNumber = null;
		}
		long count = this.tAssembleDetailMapper.selectAssembleDetailCount(batchNumber,cardBindingNumber);
		return (int) count;
	}

	@Override
	public List<AssembleDetailEntity> getAssembleDetailBybatchNumber(String batchNumber) {
		if (StringUtils.isEmptyOrWhitespace(batchNumber)) {
			batchNumber = null;
		}
		List<AssembleDetailEntity> assembleDetailEntityList = this.tAssembleDetailMapper
				.selectAssembleDetailBybatchNumber(batchNumber);
		return assembleDetailEntityList;
	}

	@Override
	public int getLoGradeHistoryCount() {
		TLoGradeHistoryExample example = new TLoGradeHistoryExample();

		long count = this.tLoGradeHistoryMapper.countByExample(example);
		return (int) count;
	}

	@Override
	public List<TLoGradeHistory> getLoGradeHistory() {
		TLoGradeHistoryExample example = new TLoGradeHistoryExample();

		List<TLoGradeHistory> list = this.tLoGradeHistoryMapper.selectByExample(example);
		return list;
	}

	@Override
	public long createBatchNumberPreparatoryDetail(
			List<TPreparatoryDetail> preparatoryDetailEntityList) {
		long result = tPreparatoryDetailMapper.insertPreparatory(preparatoryDetailEntityList);
		return result;
	}

	@Override
	public List<TWarningMessage> getWaringMessage() {
		TWarningMessageExample example = new TWarningMessageExample();
		List<TWarningMessage> tmList = this.tWarningMessageMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(tmList)) {
			return new ArrayList<TWarningMessage>();
		}
		return tmList;
	}

	@Override
	public long createAssemblDdetail(TAssembleDetail assembleDetail) {
		long result = tAssembleDetailMapper.insert(assembleDetail);
		return result;
	}

	@Override
	public void updateAssemblDdetail(TAssembleDetail assembleDetail) {
		TAssembleDetailExample example = new TAssembleDetailExample();
		example.createCriteria().andCardBindingNumberEqualTo(assembleDetail.getCardBindingNumber());
		tAssembleDetailMapper.updateByExampleSelective(assembleDetail, example);
		
	}

	@Override
	public void clearAssembleDetail(List<String> clearAssembleDetailList) {
		tAssembleDetailMapper.clearAssembleDetail(clearAssembleDetailList);
	}

	@Override
	public List<TAssembleDetail>  getBatchNumberBybingNumber(String cardBindingNumber) {
		TAssembleDetailExample example = new TAssembleDetailExample();
		example.createCriteria().andCardBindingNumberEqualTo(cardBindingNumber);
		List<TAssembleDetail> list = tAssembleDetailMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public void clearPreparatoryDetail(List<String> clearPreparatoryDetaillList) {
		tPreparatoryDetailMapper.clearPreparatoryDetail(clearPreparatoryDetaillList);
	}

}

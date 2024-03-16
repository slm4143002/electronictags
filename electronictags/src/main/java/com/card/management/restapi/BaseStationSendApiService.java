package com.card.management.restapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.card.management.restapi.eslpojo.EslRequestTemplate;
import com.card.management.restapi.eslpojo.EslResponseResult;
import com.card.management.restapi.eslpojo.F1Template;
import com.card.management.restapi.eslpojo.ProductAssembleTemplate;
import com.card.management.restapi.eslpojo.ProductClearTemplate;
import com.card.management.restapi.eslpojo.ProductPreparatoryTemplate;
import com.card.management.restapi.eslpojo.ProductTemplate;
import com.card.management.restapi.pojo.RestInputAssembleCard;
import com.card.management.restapi.pojo.RestInputCard;
import com.card.management.restapi.pojo.RestInputClearCard;
import com.card.management.restapi.pojo.RestInputPreparatoryCard;

@Service
public class BaseStationSendApiService {

	@Autowired
	public BaseStationRestTemplate baseStationRestTemplate;

	@Autowired
	public PropertiesModel pmodel;

	// 推送刷屏数据
	public String postRequest(RestInputCard restInputCard, TemplateEnum templateEnum) {
		EslRequestTemplate template = new EslRequestTemplate();
		template.setStore_code(pmodel.getStoreCode());
		template.setIs_base64(pmodel.getIsBase64());
		template.setSign(pmodel.getSign());
		F1Template f1 = new F1Template();

		switch (templateEnum) {
		// 筹备
		case PREPARATORY:
			RestInputPreparatoryCard rpCard = (RestInputPreparatoryCard) restInputCard;
			List<ProductTemplate> ptList0 = new ArrayList<ProductTemplate>();
			rpCard.getCardInfoList().forEach(cardInfo -> {
				ProductPreparatoryTemplate pt = new ProductPreparatoryTemplate();
				// 批量号
				pt.setPc(rpCard.getBatchNumber());
				// 台数总
				pt.setPn(rpCard.getMachineCount());
				// 日期
				pt.setPd(rpCard.getWriteDate());
				//  车数当前
				pt.setPp(cardInfo.getCardCount());
				// 电子卡片信息
				pt.setEsl_code(cardInfo.getCardInfo());
				// 筹备模板
				pt.setTemplate_id(pmodel.getTemplateIdPreparatory());
				ptList0.add(pt);
			});
			f1.setProductTemplate(ptList0);
			template.setF1(f1);
			break;
		// 组装
		case ASSEMBLE:
			RestInputAssembleCard raCard1 = (RestInputAssembleCard) restInputCard;
			List<ProductTemplate> ptList1 = new ArrayList<ProductTemplate>();
			ProductAssembleTemplate pt = new ProductAssembleTemplate();
			// 批量号
			pt.setPc(raCard1.getBatchNumber());
			// 组装结果
			pt.setP1(raCard1.getAssembleResult());
			// 接地结果
			pt.setP2(raCard1.getGroundConnectionResult());
			// 耐压结果
			pt.setP3(raCard1.getWithstandVoltageResult());
			// UT结果
			pt.setP4(raCard1.getUtResult());
			// 台数当前
			pt.setPp(raCard1.getRestCardInfo().getCardCount());
			// 电子卡片信息
			pt.setEsl_code(raCard1.getRestCardInfo().getCardInfo());
			// 组装模板
			pt.setTemplate_id(pmodel.getTemplateIdAssemble());
			ptList1.add(pt);
			f1.setProductTemplate(ptList1);
			template.setF1(f1);
			break;
		// 清屏
		case CLEAR:
			RestInputClearCard raCard2 = (RestInputClearCard) restInputCard;
			List<ProductTemplate> ptList2 = new ArrayList<ProductTemplate>();

			raCard2.getCardInfoList().forEach(clearNumber -> {
				ProductClearTemplate pt2 = new ProductClearTemplate();
				// 电子屏ID
				pt2.setEsl_code(clearNumber);
				// 清屏模板
				pt2.setTemplate_id(pmodel.getTemplateIdClear());
				ptList2.add(pt2);
			});
			f1.setProductTemplate(ptList2);
			template.setF1(f1);
			break;
		}
		ResponseEntity<EslResponseResult> result = sendPostRequest(pmodel.getApiUrl(),template,EslResponseResult.class);
		EslResponseResult eslResult= result.getBody();
		
		return eslResult.getError_code();
	}

	public <T> ResponseEntity<T> sendPostRequest(String url, Object requestBody, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);
		ResponseEntity<T> responseEntity = baseStationRestTemplate.restTemplate().postForEntity(url, requestEntity,
				responseType);
		return responseEntity;
	}
}

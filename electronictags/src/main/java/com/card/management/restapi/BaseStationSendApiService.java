package com.card.management.restapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.card.management.restapi.eslpojo.EslRequestQueryTemplate;
import com.card.management.restapi.eslpojo.EslRequestTemplate;
import com.card.management.restapi.eslpojo.EslResponseResult;
import com.card.management.restapi.eslpojo.F1Template;
import com.card.management.restapi.eslpojo.Product;
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

	// 拉取水墨屏结果状态
	public List<java.util.LinkedHashMap> getEslResult(List<String> f3List) {
		EslRequestQueryTemplate template = new EslRequestQueryTemplate();
		template.setStore_code(pmodel.getStoreCode());
		template.setIs_base64(pmodel.getIsBase64());
		template.setSign(pmodel.getSign());
		template.setF1(1);
		template.setF2(10);
		template.setF3(f3List);
		try {
			ResponseEntity<ArrayList> result = sendPostRequest(pmodel.getApiQueryUrl(), template, ArrayList.class);
			ArrayList<java.util.LinkedHashMap> eslResult = result.getBody();
			return eslResult;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 推送刷屏数据
	public String postRequest(RestInputCard restInputCard, TemplateEnum templateEnum) {
		EslRequestTemplate template = new EslRequestTemplate();
		template.setStore_code(pmodel.getStoreCode());
		template.setIs_base64(pmodel.getIsBase64());
		template.setSign(pmodel.getSign());
		try {
			switch (templateEnum) {
			// 筹备
			case PREPARATORY:
				RestInputPreparatoryCard rpCard = (RestInputPreparatoryCard) restInputCard;
				List<F1Template> f1List = new ArrayList<F1Template>();
				rpCard.getCardInfoList().forEach(cardInfo -> {
					F1Template f1 = new F1Template();
					// 水墨屏id
					f1.setEsl_code(cardInfo.getCardInfo());
					// 筹备模板
					f1.setTemplate_id(pmodel.getTemplateIdPreparatory());
					Product product = new Product();
					// 机种名称
					product.setF1(rpCard.getMachineCategoryName());
					// 台数总
					product.setF2(rpCard.getMachineCount());
					// 车数当前
					product.setF3(cardInfo.getCardCount());
					// 批量号
					product.setF4(rpCard.getBatchNumber());
					// 日期
					product.setF5(rpCard.getWriteDate());
					f1.setProduct(product);
					f1List.add(f1);
				});

				template.setF1(f1List);

				break;
			// 组装
			case ASSEMBLE:
				RestInputAssembleCard raCard1 = (RestInputAssembleCard) restInputCard;
				List<F1Template> f2List = new ArrayList<F1Template>();
				F1Template f2 = new F1Template();
				// 水墨屏id
				f2.setEsl_code(raCard1.getRestCardInfo().getCardInfo());
				// 筹备模板
				f2.setTemplate_id(pmodel.getTemplateIdAssemble());

				Product product1 = new Product();
				// 机种名称
				product1.setF1(raCard1.getMachineCategoryName());
				// 组装结果
				product1.setF2(raCard1.getAssembleResult());
				// 接地结果
				product1.setF3(raCard1.getGroundConnectionResult());
				// 耐压结果
				product1.setF4(raCard1.getWithstandVoltageResult());
				// UT结果
				product1.setF5(raCard1.getUtResult());
				// 组装批量号
				product1.setF6(raCard1.getBatchNumber());
				// 车数当前
				product1.setF7(raCard1.getRestCardInfo().getCardCount());
				f2.setProduct(product1);
				f2List.add(f2);

				template.setF1(f2List);

				break;
			// 清屏
			case CLEAR:
				RestInputClearCard raCard3 = (RestInputClearCard) restInputCard;
				List<F1Template> f3List = new ArrayList<F1Template>();
				raCard3.getCardInfoList().forEach(cardInfo -> {
					F1Template f3 = new F1Template();
					// 水墨屏id
					f3.setEsl_code(cardInfo);
					// 筹备模板
					f3.setTemplate_id(pmodel.getTemplateIdClear());
					Product product2 = new Product();
					f3.setProduct(product2);
					f3List.add(f3);
				});

				template.setF1(f3List);

				break;
			}

			ResponseEntity<EslResponseResult> result = sendPostRequest(pmodel.getApiUrl(), template,
					EslResponseResult.class);
			EslResponseResult eslResult = result.getBody();
			System.out.println(eslResult.getError_msg());
			return eslResult.getError_code();

		} catch (Exception e) {
			// 基站异常
			e.printStackTrace();
			return "1";
		}

	}

	public <T> ResponseEntity<T> sendPostRequest(String url, Object requestBody, Class<T> responseType)
			throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);
		ResponseEntity<T> responseEntity = baseStationRestTemplate.restTemplate().postForEntity(url, requestEntity,
				responseType);
		return responseEntity;
	}
}

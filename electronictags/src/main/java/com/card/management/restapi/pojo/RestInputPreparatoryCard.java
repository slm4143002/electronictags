package com.card.management.restapi.pojo;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class RestInputPreparatoryCard extends RestInputCard {

	@NotBlank(message = "{batchNumber.notBlank}")
	private String batchNumber;
	private String machineCategoryName;
	@NotBlank(message = "{machineCount.notBlank}")
	private String machineCount;
	@NotBlank(message = "{carCount.notBlank}")
	private String carCount;
	@NotBlank(message = "{writeDate.notBlank}")
	private String writeDate;
	@NotEmpty(message = "{cardInfoList.notempty}")
	private List<RestCardInfo>  cardInfoList;

}

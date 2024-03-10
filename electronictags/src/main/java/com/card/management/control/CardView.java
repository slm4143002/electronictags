package com.card.management.control;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.card.management.entity.TWarningMessage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CardView {

	@NotBlank(message = "{batchNumber.notBlank}")
	private String batchNumber;
	@NotBlank(message = "{machineCategoryName.notBlank}")
	private String machineCategoryName;
	@NotBlank(message = "{machineCount.notBlank}")
	private String machineCount;
	@NotBlank(message = "{carCount.notBlank}")
	private String carCount;
	@NotBlank(message = "{writeDate.notBlank}")
	@DateTimeFormat (pattern="yyyy-mm-dd")
	private String writeDate;
	@NotEmpty(message = "{cardInfoList.notempty}")
	private List<CardInfo>  cardInfoList;
	private List<TWarningMessage>  warningMessageList;
	private String infoMessage;

}

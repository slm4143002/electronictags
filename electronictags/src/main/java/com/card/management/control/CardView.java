package com.card.management.control;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CardView {

	@NotNull
	@Size(min=10, max=30)
	private String batchNumber;
	@NotNull
	private String machineCategoryName;
	@NotNull
	private String machineCount;
	@NotNull
	private String carCount;
	@NotNull
	private String writeDate;
	@NotNull
	private List<CardInfo>  cardInfoList;
	private String infoMessage;

}

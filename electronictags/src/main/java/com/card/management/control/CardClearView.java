package com.card.management.control;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CardClearView {

	private List<CardInfo> cardInfoList;
	private String infoMessage;
	private String errorMessage;

}

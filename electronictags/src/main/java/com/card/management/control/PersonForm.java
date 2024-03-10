package com.card.management.control;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PersonForm {

	@Size(min=2, max=30)
	private String name;

	@NotNull
	@Min(18)
	private Integer age;

}

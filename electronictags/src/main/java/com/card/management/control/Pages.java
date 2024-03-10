package com.card.management.control;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Pages<T> {
    private Integer total;
    private List<T> rows;
}

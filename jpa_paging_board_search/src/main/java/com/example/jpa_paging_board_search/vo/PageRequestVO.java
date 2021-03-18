package com.example.jpa_paging_board_search.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageRequestVO {

	private String searchType;
	private String keyword;

}

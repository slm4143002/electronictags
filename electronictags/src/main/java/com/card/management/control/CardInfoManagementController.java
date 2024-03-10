/**
 * 
 */
package com.card.management.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.card.management.entity.MBatchNumber;
import com.card.management.service.CardInfoManagementService;

/**
 * @author slm
 *
 */
@RestController
public class CardInfoManagementController {
	
	@Autowired
	public CardInfoManagementService service;

	@GetMapping("/cards")
	public MBatchNumber getCards(@RequestParam(value = "batchNumber") String batchNumber) {
		return service.getCards(batchNumber);
	}
	

}

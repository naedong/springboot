package kr.co.e4net.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.e4net.dto.TbMoneyTransferHstDto.TbMembMoneyBoard;
import kr.co.e4net.service.TbMoneyTransferHstService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TbMoneyTransferHstController {

	private final TbMoneyTransferHstService tbMoneyTransferHstService;
	
	
	@GetMapping("moneyboard/board/{id}")
	public ResponseEntity<List<TbMembMoneyBoard>> boardTable(@PathVariable String id, Pageable pageable ){
		
		System.out.println(id);
		System.out.println("id값 확인");
		return ResponseEntity.ok(tbMoneyTransferHstService.boardTable(id));
	}
	
	
}	


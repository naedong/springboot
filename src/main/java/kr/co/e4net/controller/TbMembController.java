package kr.co.e4net.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import kr.co.e4net.dto.TbMembDto.TbMembLogin;
import kr.co.e4net.dto.TbMembDto.TbMembSign;
import kr.co.e4net.service.RetrofitService;
import kr.co.e4net.service.TbMembService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TbMembController {
	
	private final TbMembService tbMembService;
	private final RetrofitService retrofitService;
	
	@PostMapping("/test")
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("테스트 완료");
	}

	
   @PostMapping("login")
    public ResponseEntity<String> defaultUser(TbMembSign tbMembSign){
        tbMembService.defaultAdmin(tbMembSign);
        return ResponseEntity.ok("완료");
    }	 

     
    @PostMapping("login/sign")
    public ResponseEntity<Boolean> insertUser(@RequestBody TbMembSign tbMembSign){
    	
        return ResponseEntity.ok(tbMembService.insertUser(tbMembSign));
    }
    
    
    @GetMapping("login/checkid/{membId}")
    public ResponseEntity<Boolean> checkUser(@PathVariable String membId){
    	return 	ResponseEntity.ok(tbMembService.CheckID(membId));
    }
    
    
    @PostMapping("login/login")
    public ResponseEntity<TbMembSign> webLogin( @RequestBody TbMembLogin tbMembLogin){
    	
    	System.out.println(tbMembService.webLogin(tbMembLogin)+ "여기 컨트롤러");
    	return 	ResponseEntity.ok(tbMembService.webLogin(tbMembLogin) );
    }
    
    
    @GetMapping("login/getid")
    public ResponseEntity<String> idCheck(@RequestBody String id){
    
    	return ResponseEntity.ok(id);
    }
    
    

}

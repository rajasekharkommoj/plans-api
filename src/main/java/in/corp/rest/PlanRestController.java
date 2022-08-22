package in.corp.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.corp.entity.Plan;
import in.corp.service.PlanService;

@RestController
public class PlanRestController {
	@Autowired
	private PlanService planService;
	@GetMapping("/Categories")
	public ResponseEntity<Map<Integer,String>> planCategories(){
		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
		
	}
	@PostMapping("/plan")
	public ResponseEntity<String>savePlan(@RequestBody Plan plan){
		String responseMsg="";
		boolean isSaved= planService.savePlan(plan);
		if(isSaved) {
			responseMsg="PlanSaved";
		}else {
			responseMsg="PlanNotSave";
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
		
		
	}
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> Plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);
	
	}
	@GetMapping("/plans/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan= planService.getPlanById(planId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(Plan plan){
		boolean isUpdated= planService.updatePlan(plan);
		 String msg="";
		    if(isUpdated) {
		    	msg="Plan Updated";
		    }else {
		    	msg="Plan Not Updated";
		    }
		    	
			return new ResponseEntity<>(msg,HttpStatus.OK);
			
		}
		
	
	@DeleteMapping("/plans/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
	    boolean isDelete = planService.deletePlan(planId);
	    String msg="";
	    if(isDelete) {
	    	msg="Plan Deleted";
	    }else {
	    	msg="Plan Not Deleted";
	    }
	    	
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		boolean isStatusChanged = planService.planStatusChange(planId, status);
		String msg="";
	    if(isStatusChanged) {
	    	msg="Plan Status Changed";
	    }else {
	    	msg="Plan Status Not Changed";
	    }
	    	
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
}
	
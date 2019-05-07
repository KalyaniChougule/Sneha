package com.syntel.microservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.bo.ConsumerHandler;
import com.syntel.bo.MessageProducer;
import com.syntel.dao.MemberClaimDataDAO;
import com.syntel.model.MemberClaimDetail;
import com.syntel.model.MemberClaimSearchCriteria;
import com.syntel.model.Message;

/**
 * This restContoller will handle all REST endpoints exposed by this micro service
 * e.g. http://<servername>:port/sample/...
 * 
 */
@RestController
@RequestMapping(value = "/sample")
public class SampleAtomMicroService {
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(SampleAtomMicroService.class);
	
	/** The Constant VERSION of the micro service. */
	public static final String VERSION = "1.0";

	/** The member claim detail DAO. */
	@Autowired
	private MemberClaimDataDAO memberClaimDetailDAO;

	@Autowired
	private MessageProducer producer;
	
	@Autowired
	private ConsumerHandler consumerHandler;
	
	/**
	 * REST method that gets the member claim data.
	 * The @Validated annotation for input POJO will fire the validation defined in MemberClaimSearchCriteria class
	 *  
	 * @param criteria the criteria
	 * @return the member claim data
	 */
	@RequestMapping(value = "/memberClaimDetails/"+ VERSION,consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<MemberClaimDetail>> getMemberClaimData(@RequestBody @Validated MemberClaimSearchCriteria criteria) {
		
		LOG.info("Called getMemberClaimData for MemberId: " + criteria.getMemberId() + " status: " + criteria.getStatus());
		return new ResponseEntity<List<MemberClaimDetail>>(memberClaimDetailDAO.getMemberClaimData(criteria),HttpStatus.OK);
	}

	@RequestMapping(value = "/sayHello/"+ VERSION, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> sayHi() {
		return new ResponseEntity<String>("Hello World!!!",HttpStatus.OK);
	}
	


	/**
	 * sendMessage() can be used send new message to Kafka topic  
	 * @param message : String message 
	 * @return success code
	 */
	@RequestMapping(value = "/sendMessage/" + VERSION, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody String sendMessage(@RequestBody Message message) {
		return producer.send(message.getMessage());
	}
	
	/**
	 * listenMessage() starts listening to kafka topic    
	 * @param message : String message 
	 * @return success code
	 */
	@RequestMapping(value = "/startListening/" + VERSION, method = RequestMethod.GET)
	public void listenMessage() {
		consumerHandler.start();
	}
	 
}

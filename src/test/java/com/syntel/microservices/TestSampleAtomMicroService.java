package com.syntel.microservices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syntel.app.SampleAtomMicroServiceApplication;
import com.syntel.model.MemberClaimDetail;
import com.syntel.model.MemberClaimSearchCriteria;
// checking
/**
 * Test class to verify the REST service call.
 * 1. First test case with autowired REST controller instance
 * 2. Second test case with use of REST Template api and REST URL of Sample Micro service
 * 
 * @author syntel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleAtomMicroServiceApplication.class)
@WebIntegrationTest
public class TestSampleAtomMicroService {

	@Autowired
	private SampleAtomMicroService sampleMicroService;
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	private HttpEntity<String> httpEntity;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	final String REST_URL="http://localhost:9081/sample/memberClaimDetails/1.0";
	
	/**
	 * Verify the REST call using "sampleMicroService" rest controller and assert few output values 
	 */
	@Test
	public void testMemberClaimData() {
		MemberClaimSearchCriteria searchCriteria = new MemberClaimSearchCriteria();
		searchCriteria.setMemberId("MID2000330");
		searchCriteria.setStatus("Approved");
		ResponseEntity<List<MemberClaimDetail>> memberClaimDetails = sampleMicroService
				.getMemberClaimData(searchCriteria);
		Assert.assertEquals(2, memberClaimDetails.getBody().size());
		Assert.assertEquals("JOHN14532", memberClaimDetails.getBody().get(0).getMrn());
	}

	/**
	 * Test member claim data using REST URL. 
	 * The port mentioned in URL is copied from application.yml of this Spring boot app
	 * 
	 * @throws RestClientException the rest client exception
	 * @throws URISyntaxException the URI syntax exception
	 * @throws JsonProcessingException the json processing exception
	 */
	@Test
	public void testMemberClaimData_using_RestTemplate()
			throws RestClientException, URISyntaxException, JsonProcessingException {
		Map<String, Object> requestBody = new HashMap<String, Object>();

		requestBody.put("memberId", "MID2003455");
		requestBody.put("satus", "Approved");
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		httpEntity = new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

		ResponseEntity<MemberClaimDetail[]> apiResponse = restTemplate.postForEntity(
				new URI(REST_URL), httpEntity, MemberClaimDetail[].class);
		assertNotNull(apiResponse);
		List<MemberClaimDetail> memberClaimsData = Arrays.asList(apiResponse.getBody());
		assertEquals(2, memberClaimsData.size());
		assertNotNull(memberClaimsData);
	}

}
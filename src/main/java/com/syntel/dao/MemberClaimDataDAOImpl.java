package com.syntel.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.syntel.model.MemberClaimDetail;
import com.syntel.model.MemberClaimSearchCriteria;

/**
 * The Class MemberClaimDataDAOImpl. This class is used to pull the data from
 * database For demo purpose some hard coded data for Claim Information is
 * returned to the user
 */

@Repository
public class MemberClaimDataDAOImpl implements MemberClaimDataDAO {

	private static final Logger LOG = LoggerFactory.getLogger(MemberClaimDataDAOImpl.class);

	public List<MemberClaimDetail> getMemberClaimData(MemberClaimSearchCriteria searchCriteria) {
		LOG.info("Fetching member Data");
		List<MemberClaimDetail> memberList = new ArrayList<MemberClaimDetail>();

		MemberClaimDetail member = new MemberClaimDetail();

		member.setProviderName("John Smith");
		member.setProviderNPI("J123");
		member.setServiceDate(searchCriteria.getFromDate());
		member.setMrn("JOHN14532");
		member.setRelationToMember("Self");
		member.setTotalCharges(BigDecimal.valueOf(1000.12));
		member.setClaimID("J123");
		member.setClaimStatusCategory("D1");
		member.setClaimStatusCatCodeDescription("In Network");
		member.setClaimAdjudicationDate(searchCriteria.getToDate());
		member.setClaimAdjustmentDate(searchCriteria.getToDate());
		member.setPendedStatusReason("");
		member.setApprovedClaimAmount(BigDecimal.valueOf(800.12));
		member.setApprovedClaimPaymentAmount(BigDecimal.valueOf(500.12));
		member.setMemberLiabilityAmount(BigDecimal.valueOf(300.12));
		memberList.add(member);

		MemberClaimDetail member2 = new MemberClaimDetail();

		member2.setProviderName("Ashley Smith");
		member2.setProviderNPI("JA3334445");
		member2.setServiceDate(Date.valueOf("2014-02-12"));
		member2.setMrn("BROMENN");
		member2.setRelationToMember("Spouse");
		member2.setTotalCharges(BigDecimal.valueOf(500));
		member2.setClaimID("AS14423");
		member2.setClaimStatusCategory("N2");
		member2.setClaimStatusCatCodeDescription("Out of Network");
		member2.setClaimAdjudicationDate(searchCriteria.getToDate());
		member2.setClaimAdjustmentDate(searchCriteria.getToDate());
		member2.setPendedStatusReason("");
		member2.setApprovedClaimAmount(BigDecimal.valueOf(500));
		member2.setApprovedClaimPaymentAmount(BigDecimal.valueOf(500));
		member2.setMemberLiabilityAmount(BigDecimal.valueOf(0.0));
		memberList.add(member2);

		return memberList;

	}

}

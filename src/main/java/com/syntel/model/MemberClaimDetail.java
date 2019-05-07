package com.syntel.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class MemberClaimDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7887069454881157297L;
	private String providerName;
	private String providerNPI;
	private Date serviceDate;
	private String mrn;
	private String relationToMember;
	private BigDecimal totalCharges;
	private String claimID;
	private String claimStatusCategory;
	private String claimStatusCatCodeDescription;
	private Date claimAdjustmentDate;
	private String pendedStatusReason;
	private Date claimAdjudicationDate;
	private BigDecimal approvedClaimAmount;
	private BigDecimal approvedClaimPaymentAmount;
	private BigDecimal memberLiabilityAmount;
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderNPI() {
		return providerNPI;
	}
	public void setProviderNPI(String providerNPI) {
		this.providerNPI = providerNPI;
	}
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	public String getMrn() {
		return mrn;
	}
	public void setMrn(String mrn) {
		this.mrn = mrn;
	}
	public String getRelationToMember() {
		return relationToMember;
	}
	public void setRelationToMember(String relationToMember) {
		this.relationToMember = relationToMember;
	}
	public BigDecimal getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(BigDecimal totalCharges) {
		this.totalCharges = totalCharges;
	}
	public String getClaimID() {
		return claimID;
	}
	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}
	public String getClaimStatusCategory() {
		return claimStatusCategory;
	}
	public void setClaimStatusCategory(String claimStatusCategory) {
		this.claimStatusCategory = claimStatusCategory;
	}
	 
	public Date getClaimAdjustmentDate() {
		return claimAdjustmentDate;
	}
	public void setClaimAdjustmentDate(Date claimAdjustmentDate) {
		this.claimAdjustmentDate = claimAdjustmentDate;
	}
	public String getPendedStatusReason() {
		return pendedStatusReason;
	}
	public void setPendedStatusReason(String pendedStatusReason) {
		this.pendedStatusReason = pendedStatusReason;
	}
	public Date getClaimAdjudicationDate() {
		return claimAdjudicationDate;
	}
	public void setClaimAdjudicationDate(Date claimAdjudicationDate) {
		this.claimAdjudicationDate = claimAdjudicationDate;
	}
	public BigDecimal getApprovedClaimAmount() {
		return approvedClaimAmount;
	}
	public void setApprovedClaimAmount(BigDecimal approvedClaimAmount) {
		this.approvedClaimAmount = approvedClaimAmount;
	}
	public BigDecimal getApprovedClaimPaymentAmount() {
		return approvedClaimPaymentAmount;
	}
	public void setApprovedClaimPaymentAmount(BigDecimal approvedClaimPaymentAmount) {
		this.approvedClaimPaymentAmount = approvedClaimPaymentAmount;
	}
	public BigDecimal getMemberLiabilityAmount() {
		return memberLiabilityAmount;
	}
	public void setMemberLiabilityAmount(BigDecimal memberLiabilityAmount) {
		this.memberLiabilityAmount = memberLiabilityAmount;
	}
	public String getClaimStatusCatCodeDescription() {
		return claimStatusCatCodeDescription;
	}
	public void setClaimStatusCatCodeDescription(
			String claimStatusCatCodeDescription) {
		this.claimStatusCatCodeDescription = claimStatusCatCodeDescription;
	}
	
		 
	
	
	


	
	

}

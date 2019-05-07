package com.syntel.model;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// TODO: Auto-generated Javadoc
/**
 * The Class MemberClaimSearchCriteria.
 */
public class MemberClaimSearchCriteria implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7015012731023172946L;
	
	/** The member id. */
	@NotNull
	@Size(min=5, max=10)
	private String memberId;
	
	/** The from date. */
	private Date fromDate;
	
	/** The to date. */
	private Date toDate;
	
	/** The status. */
	private String status;
	
	
	/**
	 * Gets the member id.
	 *
	 * @return the member id
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * Sets the member id.
	 *
	 * @param memberId the new member id
	 */	

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * Gets the from date.
	 *
	 * @return the from date
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * Sets the from date.
	 *
	 * @param fromDate the new from date
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets the to date.
	 *
	 * @return the to date
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * Sets the to date.
	 *
	 * @param toDate the new to date
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}

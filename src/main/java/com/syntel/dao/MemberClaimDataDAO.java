package com.syntel.dao;


import java.util.List;

import com.syntel.model.MemberClaimDetail;
import com.syntel.model.MemberClaimSearchCriteria;


public interface MemberClaimDataDAO {
 
	public List<MemberClaimDetail> getMemberClaimData(MemberClaimSearchCriteria searchCriteria);

}

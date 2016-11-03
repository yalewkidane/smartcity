package org.gs1.smartcity.identification;

import org.gs1.smartcity.db.mongo.DAOFactory;
import org.gs1.smartcity.db.mongo.DataAccessObject;
import org.gs1.smartcity.util.CheckBit;

public class Identification {
	
	private DataAccessObject companyPrefixDao;
	private DataAccessObject dao;
	private String id;
	
	public Identification() {
		
		companyPrefixDao = (new DAOFactory()).getDAO(DAOFactory.COMPANY_PREFIX);
		dao = null;
		id = null;
	}
	
	public String identifyGIAI(String companyID, String objectID) {
		
		dao = (new DAOFactory()).getDAO(DAOFactory.GIAI);
		
		if(dao.queryKey(objectID) == null) {
			String companyPrefix = companyPrefixDao.queryKey(companyID); 
			String reference = String.valueOf(dao.getCheckNum());
			if(reference.length() > 8) {
				return null;
			}
			id = companyPrefix + "00000000".substring(0, 8 - reference.length()) + reference;
			dao.register(objectID, id);
		}
		
		return id;
	}
	
	public String identifyGLN(String companyID, String objectID) {
		
		dao = (new DAOFactory()).getDAO(DAOFactory.GLN);
		
		if(dao.queryKey(objectID) == null) {
			String companyPrefix = companyPrefixDao.queryKey(companyID); 
			String reference = String.valueOf(dao.getCheckNum() + 1);
			if(reference.length() > 4) {
				return null;
			}
			CheckBit checkBit = new CheckBit();
			id = companyPrefix + "0000".substring(0, 4 - reference.length()) + reference;
			id = id + checkBit.generateCheckBit(id);
			dao.register(objectID, id);
		}
		
		return id;
	}
	
	public String identifyGSRN(String companyID, String objectID) {
		
		dao = (new DAOFactory()).getDAO(DAOFactory.GSRN);
		
		if(dao.queryKey(objectID) == null) {
			String companyPrefix = companyPrefixDao.queryKey(companyID); 
			String reference = String.valueOf(dao.getCheckNum() + 1);
			if(reference.length() > 9) {
				return null;
			}
			CheckBit checkBit = new CheckBit();
			id = companyPrefix + "000000000".substring(0, 9 - reference.length()) + reference;
			id = id + checkBit.generateCheckBit(id);
			dao.register(objectID, id);
		}
		
		return id;
	}

}

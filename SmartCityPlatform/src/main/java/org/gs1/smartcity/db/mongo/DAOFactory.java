package org.gs1.smartcity.db.mongo;

public class DAOFactory {

	public static final String COMPANY_PREFIX = "companyPrefix";
	public static final String GIAI = "giai";
	public static final String GLN = "gln";
	public static final String GSRN = "gsrn";

	public DataAccessObject getDAO(String type) {
		DataAccessObject dataAccessObject = null;

		if(type.equals(COMPANY_PREFIX)) {
			dataAccessObject = new ComapnyPrefixDAO();
		} else if(type.equals(GIAI)) {
			dataAccessObject = new GiaiDAO();
		} else if(type.equals(GLN)) {
			dataAccessObject = new GlnDAO();
		} else if(type.equals(GSRN)) {
			dataAccessObject = new GsrnDAO();
		}

		return dataAccessObject;
	}
}

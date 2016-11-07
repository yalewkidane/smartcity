package org.gs1.smartcity.db.mongo;

public class DAOFactory {

	public static final String COMPANY_PREFIX = "companyPrefix";
	public static final String GIAI = "giai";
	public static final String GLN = "gln";
	public static final String GSRN = "gsrn";
	public static final String OBJECT_SERVICE = "objectService";
	public static final String SERVICE_CLASS = "serviceClass";
	public static final String SERVICE = "service";

	public DataAccessObject getDAO(String type) {
		DataAccessObject dataAccessObject = null;

		if(type.equals(COMPANY_PREFIX)) {
			dataAccessObject = new CompanyPrefixDAO();
		} else if(type.equals(GIAI)) {
			dataAccessObject = new GiaiDAO();
		} else if(type.equals(GLN)) {
			dataAccessObject = new GlnDAO();
		} else if(type.equals(GSRN)) {
			dataAccessObject = new GsrnDAO();
		} else if(type.equals(OBJECT_SERVICE)) {
			dataAccessObject = new ObjectServiceDAO();
		} else if(type.equals(SERVICE_CLASS)) {
			dataAccessObject = new ServiceClassDAO();
		} else if(type.equals(SERVICE)) {
			dataAccessObject = new ServiceDAO();
		}

		return dataAccessObject;
	}
}

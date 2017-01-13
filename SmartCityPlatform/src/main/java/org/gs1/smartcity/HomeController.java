package org.gs1.smartcity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

import org.gs1.smartcity.capturing.ObjectCollector;
import org.gs1.smartcity.capturing.eventdata.EventCapturer;
import org.gs1.smartcity.services.ServiceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private Timer timer;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	@RequestMapping(value = "/startServiceEventCapture", method = RequestMethod.POST)
	public ResponseEntity<String> startServiceEventCapture(@RequestParam(value = "serviceClass") final String serviceClass,
			@RequestParam(value = "serviceName") final String serviceName,
			@RequestParam(value = "serviceType") final String serviceType,
			@RequestParam(value = "serviceObject") final String serviceObject,
			@RequestParam(value = "serviceObject2", required=false) final String serviceObject2) {

		List<String> params = new ArrayList<String>();
		params.add(serviceObject);
		if(serviceObject2 != null) {
			params.add(serviceObject2);
		}
		
		EventCapturer eventCapturer = new EventCapturer(serviceClass, serviceName, serviceType, params);
		
		timer = new Timer();
		timer.schedule(eventCapturer, 0, 60000);
		
		return new ResponseEntity<String>(new String("Service event capturing for " + serviceObject + " is started."), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/stopServiceEventCapture", method = RequestMethod.POST)
	public ResponseEntity<String> stopServiceEventCapture() {
		
		timer.cancel();
		timer.purge();
		
		return new ResponseEntity<String>(new String("Service event capturing is stoped."), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getServiceList", method = RequestMethod.GET)
	public ResponseEntity<String> getServiceList(@RequestParam(value = "id") final String id) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		ServiceManager serviceManager = new ServiceManager();
		String serviceList = serviceManager.getServiceList(id);
		
		return new ResponseEntity<String>(serviceList, responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerServiceClass", method = RequestMethod.POST)
	public ResponseEntity<String> registerServiceClass(@RequestParam(value = "classID") final String classID,
			@RequestParam(value = "className") final String className) {

		ServiceManager serviceManager = new ServiceManager();
		boolean reg = serviceManager.registerServiceClass(classID, className);
		if(reg == true) {
			return new ResponseEntity<String>(new String("Service Class is registered(" + className + ")"), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(new String("Service Class registration is failed"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/registerService", method = RequestMethod.POST)
	public ResponseEntity<String> registerService(@RequestParam(value = "className") final String className,
			@RequestParam(value = "serviceName") final String serviceName,
			@RequestParam(value = "serviceUrl") final String serviceUrl) {

		ServiceManager serviceManager = new ServiceManager();
		boolean reg = serviceManager.registerService(className, serviceName, serviceUrl);
		if(reg == true) {
			return new ResponseEntity<String>(new String("Service is registered(" + serviceName + ")"), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(new String("Service registration is failed"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/registerCompanyPrefix", method = RequestMethod.POST)
	public ResponseEntity<String> registerCompanyPrefix(@RequestParam(value = "companyID") final String companyID,
			@RequestParam(value = "companyPrefix") final String companyPrefix) {

		ObjectCollector objectCollector = new ObjectCollector();
		objectCollector.collect(companyID, companyPrefix, null, "companyPrefix");
		
		return new ResponseEntity<String>(new String("CompanyPrefix is registered(companyID: " + companyID + ", companyPrefix: " + companyPrefix + ")"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerGSRN", method = RequestMethod.POST)
	public ResponseEntity<String> registerGSRN(@RequestParam(value = "objectID") final String objectID,
			@RequestParam(value = "gsrn") final String gsrn,
			@RequestParam(value = "serviceUrl") final String serviceUrl) {

		ObjectCollector objectCollector = new ObjectCollector();
		objectCollector.collect(objectID, gsrn, serviceUrl, "gsrn");
		
		return new ResponseEntity<String>(new String("GSRN is registered(objectID: " + objectID + ", GSRN: " + gsrn + ")"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerGLN", method = RequestMethod.POST)
	public ResponseEntity<String> registerGLN(@RequestParam(value = "objectID") final String objectID,
			@RequestParam(value = "gln") final String gln,
			@RequestParam(value = "serviceUrl") final String serviceUrl) {

		ObjectCollector objectCollector = new ObjectCollector();
		objectCollector.collect(objectID, gln, serviceUrl, "gln");
		
		return new ResponseEntity<String>(new String("GLN is registered(objectID: " + objectID + ", GLN: " + gln + ")"), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registerGIAI", method = RequestMethod.POST)
	public ResponseEntity<String> registerGIAI(@RequestParam(value = "objectID") final String objectID,
			@RequestParam(value = "giai") final String giai,
			@RequestParam(value = "serviceUrl") final String serviceUrl) {

		ObjectCollector objectCollector = new ObjectCollector();
		objectCollector.collect(objectID, giai, serviceUrl, "giai");
		
		return new ResponseEntity<String>(new String("GIAI is registered(objectID: " + objectID + ", GIAI: " + giai + ")"), HttpStatus.OK);
	}

}

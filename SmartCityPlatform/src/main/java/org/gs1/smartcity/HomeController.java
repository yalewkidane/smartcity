package org.gs1.smartcity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

import org.gs1.smartcity.capturing.services.EventCapturer;
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
	public ResponseEntity<String> startServiceEventapture(@RequestParam(value = "id") final String id) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		ServiceManager serviceManager = new ServiceManager();
		String serviceList = serviceManager.getServiceList(id);
		
		return new ResponseEntity<String>(serviceList, responseHeaders, HttpStatus.OK);
	}

}

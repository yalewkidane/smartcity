package org.gs1.smartcity.capturing.masterdata;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.gs1.epcglobal.epcis.VocabularyType;
import org.gs1.smartcity.capturing.DataManager;
import org.gs1.smartcity.capturing.EPCISVocabularyMarshaller;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.DocumentIdentification;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.Partner;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.PartnerIdentification;
import org.unece.cefact.namespaces.standardbusinessdocumentheader.StandardBusinessDocumentHeader;

public abstract class MasterDataManager extends DataManager {
	
	protected EPCISVocabularyMarshaller marshaller;
	protected StandardBusinessDocumentHeader sbdh;
	protected VocabularyType voc;

	public MasterDataManager() {

		marshaller = new EPCISVocabularyMarshaller();
		sbdh = new StandardBusinessDocumentHeader();
		voc = new VocabularyType();
	}
	
	protected void headerModeling() {
		
		sbdh.setHeaderVersion("1.2");
		
		Partner sender = new Partner();
		Partner receiver = new Partner();
		
		PartnerIdentification senderId = new PartnerIdentification();
		senderId.setAuthority("admin");
		senderId.setValue("resl");
		sender.setIdentifier(senderId);
		
		PartnerIdentification receiverId = new PartnerIdentification();
		receiverId.setAuthority("user");
		receiverId.setValue("user");
		receiver.setIdentifier(receiverId);
		
		sbdh.getSenders().add(sender);
		sbdh.getReceivers().add(receiver);
		
		DocumentIdentification docId = new DocumentIdentification();
		docId.setStandard("EPCglobal");
		docId.setTypeVersion("1.2");
		docId.setInstanceIdentifier("instanceIdentifier");
		docId.setType("MasterData");
		docId.setMultipleType(true);
		docId.setCreationDateAndTime(Calendar.getInstance());
		
		sbdh.setDocumentIdentification(docId);
	}

	public int registerEPCIS(String data) {

		String url = "http://" + epcis_ip + ":" + epcis_port + "/epcis/Service/VocabularyCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		try {
			post.setEntity(new StringEntity(data));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.getStatusLine().getStatusCode();

	}

}
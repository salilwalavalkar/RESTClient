package com.tech.rest.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tech.rest.client.model.EmployeeDetails;
import com.tech.rest.client.model.EmployeeList;

/**
 * REST service client
 */
public class RestClient {

	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		RestClient r = new RestClient();
		r.getEmployeeListAllXML();
		r.getEmployeeListSingleXML();
	}

	private void getEmployeeListAllXML() {
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);

		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<EmployeeDetails> entity = new HttpEntity<EmployeeDetails>(
				headers);

		// Send the request as GET
		try {
			ResponseEntity<EmployeeList> result = restTemplate
					.exchange(
							"http://localhost:8080/RESTGetImpl/rest/employee/listAllDetails.xml",
							HttpMethod.GET, entity, EmployeeList.class);
			List<EmployeeDetails> list = result.getBody().getEmployeeDetails();
			System.out.println("List Size: " + list.size());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getEmployeeListSingleXML() {
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_XML);

		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		HttpEntity<EmployeeDetails> entity = new HttpEntity<EmployeeDetails>(
				headers);

		// Send the request as GET
		try {
			ResponseEntity<EmployeeDetails> result = restTemplate
					.exchange(
							"http://localhost:8080/RESTGetImpl/rest/employee/listDetails/1.xml",
							HttpMethod.GET, entity, EmployeeDetails.class);
			EmployeeDetails emp = result.getBody();
			System.out.println("Emp Details: " + emp.getEmpId() + "#"
					+ emp.getEmpName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

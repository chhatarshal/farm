package org.farm.base.api;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class MainApi {
	
	public static void main(String[] args) {
		Response response =
				ClientBuilder.newClient()
				.target("http://localhost:8080/service-url")
				.request()
				.get();
	}

}

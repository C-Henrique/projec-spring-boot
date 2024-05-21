package com.estudos.projecspringboot;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;

public class HttpTeste {
	public static final String URL_GET = "http://192.168.0.168:8001/sap/opu/odata/sap/ZFI_DDL_FICHA_FINANCEIRA_CDS/ZFI_DDL_FICHA_FINANCEIRA?$format=json&$filter=Empresa eq '1000' and CodCliente eq '1034819'";
	public static final String user = "E.FERNANDES";
	public static final String password = "hanaqas04";

	public static void main(String[] args) {
		HttpClient client = HttpClient.newHttpClient();
		String auth = user + ":" + password;

		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));

		HttpRequest request = HttpRequest.newBuilder().GET().timeout(Duration.ofSeconds(10)).uri(URI.create(URL_GET))
				.header("Authorization", "Basic" + new String(encodedAuth)).build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.statusCode());
			System.out.println(response.body());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

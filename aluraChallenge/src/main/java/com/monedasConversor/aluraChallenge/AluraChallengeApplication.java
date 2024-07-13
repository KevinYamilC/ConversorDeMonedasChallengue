package com.monedasConversor.aluraChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@SpringBootApplication
public class AluraChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluraChallengeApplication.class, args);
		funcionalidad();
	}

	public static void funcionalidad() {
		boolean bandera = true;
		double entrada;
		int opcion = 0;
		String menuOpciones = "Introduzca un numero:\n" +
				"1.-Convertir a dolares,\n" +
				"2.-Convertir a Peso argentino,\n" +
				"3.-Convertir a Boliviano boliviano,\n" +
				"4.-Convertir a Real brasileño,\n" +
				"5.-Para salir.";
		String mensajeCambio = "Cuantos pesos desea convertir?";
		while (bandera) {
			try {
				System.out.println(menuOpciones);
				opcion = opciones();
				switch (opcion) {
					case 1:
						System.out.println(mensajeCambio);
						entrada = entradas();
						System.out.println(entrada + " Pesos Mexicanos Son " + conversor("USD", entrada) + " Dolares.");
						break;
					case 2:
						System.out.println(mensajeCambio);
						entrada = entradas();
						System.out.println(
								entrada + " Pesos Mexicanos Son " + conversor("ARS", entrada) + " Peso argentino.");
						break;
					case 3:
						System.out.println(mensajeCambio);
						entrada = entradas();
						System.out.println(
								entrada + " Pesos Mexicanos Son " + conversor("BOB", entrada)
										+ " Boliviano boliviano.");
						break;
					case 4:
						System.out.println(mensajeCambio);
						entrada = entradas();
						System.out.println(
								entrada + " Pesos Mexicanos Son " + conversor("BRL", entrada) + " Real brasileño.");
						break;
					case 5:
						bandera = false;
						break;
					default:
						System.out.println("Nada mas numeros del menu de opciones, POR FAVOR.");
						break;
				}
			} catch (Exception e) {
				System.out.println("ERROR " + e);
			}
		}
	}

	public static int opciones() {
		Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Nada mas numeros del menu de opciones, POR FAVOR.");
			return 0;
		}
	}

	public static double entradas() {
		Scanner scanner = new Scanner(System.in);
		try {
			return scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("Solo numeros por favor");
			return 0.0;
		}
	}

	// Este metodo hace la llamada a la api
	public static double conversor(String moneda, double cuantos) {
		String Key = "https://v6.exchangerate-api.com/v6/d61e4b66c5945ad72df384ca/latest/";
		try {
			// URL del endpoint al que deseas hacer la petición
			URI uri = new URI(Key + moneda);
			URL url = uri.toURL();

			// Crear la conexión
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Configurar la petición como GET
			connection.setRequestMethod("GET");

			// Obtener el código de respuesta
			int responseCode = connection.getResponseCode();
			// System.out.println("Código de respuesta: " + responseCode);

			// Manejar la respuesta en función del código de respuesta
			if (responseCode == HttpURLConnection.HTTP_OK) { // código 200 OK
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// Imprimir la respuesta
				ResponseCoin responses = Converter.fromJsonString(response.toString());
				double valorMercado = responses.getConversionRates().get("MXN");
				double resultadoFinal = cuantos / valorMercado;
				return resultadoFinal;
				// System.out.println("El resultado es: " + resultadoFinal);
				// Si un peso = 17...
				// Cuanto es 100 = ?
				//
			} else {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// Imprimir la respuesta de error
				return 0.0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}

}

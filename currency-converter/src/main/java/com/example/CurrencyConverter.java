package com.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.*;

public class CurrencyConverter {
    private static final String API_KEY = "2cff236d406e990664f0638a";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();
    
    private static final String[] SUPPORTED_CURRENCIES = {"USD", "ARS", "BOB", "BRL", "CLP", "COP"};
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Currency Converter!");
        
        try {
            fetchAndFilterExchangeRates();
            runMainMenu();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void fetchAndFilterExchangeRates() throws IOException, InterruptedException {
        System.out.println("Fetching latest exchange rates...");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            
            for (String currency : SUPPORTED_CURRENCIES) {
                if (rates.has(currency)) {
                    exchangeRates.put(currency, rates.get(currency).getAsDouble());
                }
            }
            System.out.println("Exchange rates updated successfully.");
        } else {
            throw new IOException("API request failed with status code: " + response.statusCode());
        }
    }

    private static void runMainMenu() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Convert Currency");
            System.out.println("2. View Supported Currencies");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        performConversion(scanner);
                        break;
                    case 2:
                        viewSupportedCurrencies();
                        break;
                    case 3:
                        System.out.println("Thank you for using the Currency Converter. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void performConversion(Scanner scanner) {
        System.out.println("\n--- Currency Conversion ---");
        String sourceCurrency = getValidCurrencyInput(scanner, "Enter the source currency: ");
        String targetCurrency = getValidCurrencyInput(scanner, "Enter the target currency: ");
        
        double amount = getValidAmountInput(scanner);
        
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
        System.out.printf("%.2f %s = %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
    }

    private static String getValidCurrencyInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String currency = scanner.nextLine().toUpperCase();
            if (exchangeRates.containsKey(currency)) {
                return currency;
            }
            System.out.println("Invalid currency. Please enter one of the supported currencies.");
        }
    }

    private static double getValidAmountInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter the amount to convert: ");
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    return amount;
                }
                System.out.println("Please enter a positive amount.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static void viewSupportedCurrencies() {
        System.out.println("\n--- Supported Currencies ---");
        for (String currency : SUPPORTED_CURRENCIES) {
            System.out.println(currency);
        }
    }

    private static double convertCurrency(double amount, String from, String to) {
        double fromRate = exchangeRates.get(from);
        double toRate = exchangeRates.get(to);
        return (amount / fromRate) * toRate;
    }
}
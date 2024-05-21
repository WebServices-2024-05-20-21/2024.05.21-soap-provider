package com.comarch.szkolenia.soap.provider;

import com.comarch.szkolenia.soap.provider.countries.Country;
import com.comarch.szkolenia.soap.provider.countries.Currency;
import com.comarch.szkolenia.soap.provider.countries.GetCountryRequest;
import com.comarch.szkolenia.soap.provider.countries.GetCountryResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountriesEndpoint {

    private static final String NAMESPACE = "http://szkolenia.comarch.com/soap/provider/countries";

    @PayloadRoot(namespace = NAMESPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest getCountryRequest) {
        System.out.println(getCountryRequest.getName());
        Country country = getCountry(getCountryRequest.getName());
        GetCountryResponse getCountryResponse = new GetCountryResponse();
        getCountryResponse.setCountry(country);
        return getCountryResponse;
    }

    private Country getCountry(String name) {
        if(name.equals("Polska")) {
            Country country = new Country();
            country.setCapital("Warszawa");
            country.setName("Polska");
            country.setCurrency(Currency.PLN);
            country.setPopulation(39000000);
            return country;
        }

        if(name.equals("Hiszpania")) {
            Country country = new Country();
            country.setCapital("Madryt");
            country.setName("Hiszpania");
            country.setCurrency(Currency.EUR);
            country.setPopulation(50000000);
            return country;
        }

        if(name.equals("Wielka Brytania")) {
            Country country = new Country();
            country.setCapital("Londyn");
            country.setName("Wielka Brytania");
            country.setCurrency(Currency.GBP);
            country.setPopulation(70000000);
            return country;
        }

        return null;
    }
}

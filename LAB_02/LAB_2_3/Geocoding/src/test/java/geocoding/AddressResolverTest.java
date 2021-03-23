package geocoding;

import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Formatter;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//Sempre que se usa Mockito
@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @InjectMocks
    AddressResolver addressResolver;

    @Mock
    TqsHttpClient tqsHttpClient;

    @Test
    public void findAddressForLocation() throws URISyntaxException, IOException, ParseException, org.json.simple.parser.ParseException {
        when(tqsHttpClient.get(location(10,10))).thenReturn("{\n" +
                "    \"results\": [\n" +
                "        {\n" +
                "            \"providedLocation\": {\n" +
                "                \"latLng\": {\n" +
                "                    \"lat\": 10,\n" +
                "                    \"lng\": 10\n" +
                "                }\n" +
                "            },\n" +
                "            \"locations\": [\n" +
                "                {\n" +
                "                    \"street\": \"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\n" +
                "                    \"adminArea5\": \"Glória e Vera Cruz\",\n" +
                "                    \"adminArea3\": \"Centro\",\n" +
                "                    \"postalCode\": \"3810-193\",\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}");

        Address addressReturned = addressResolver.findAddressForLocation(10, 10);

        Address addressExpected = new Address(
                null,
                "Parque Estacionamento da Reitoria - Univerisdade de Aveiro",
                "Glória e Vera Cruz",
                "Centro",
                "3810-193"
        );
        assertThat(addressReturned, is(addressExpected));
    }

    private static String location(double lat, double lnt) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f", lat, lnt).toString() );
        uriBuilder.addParameter("includeRoadMetadata", "true" );
        return uriBuilder.build().toString();
    }

}
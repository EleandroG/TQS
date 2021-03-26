package geocoding;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class AddressResolverTestIT {


    AddressResolver addressResolver;

    @Test
    public void findAddressForLocation() throws URISyntaxException, IOException, ParseException, org.json.simple.parser.ParseException {

        Address addressReturned = addressResolver.findAddressForLocation(40.6318, -8.658);

        Address addressExpected = new Address(
                null,
                "Parque Estacionamento da Reitoria - Univerisdade de Aveiro",
                "Glória e Vera Cruz",
                "Centro",
                "3810-193"
        );
        assertThat(addressReturned, is(addressExpected));
    }

}
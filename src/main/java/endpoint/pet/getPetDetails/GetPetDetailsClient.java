package endpoint.pet.getPetDetails;

import endpoint.pet.PetResponse;
import frame.Handler;
import io.restassured.response.Response;

public class GetPetDetailsClient {

    public PetResponse getPetDetailsByID(Long id)
    {
        GetPetDetailsEndpoint getPetDetailsEndpoint = new GetPetDetailsEndpoint(id.toString());
        Response response = new Handler().requestHandler(getPetDetailsEndpoint);
        PetResponse getPetDetailsResponse = response.as(PetResponse.class);
        getPetDetailsResponse.setHttpStatusCode(response.statusCode());
        return getPetDetailsResponse;
    }
}

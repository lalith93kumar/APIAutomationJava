package endpoint.pet.updatePetDetails;

import endpoint.pet.PetRequest;
import endpoint.pet.PetResponse;
import frame.Handler;
import io.restassured.response.Response;

public class UpdatePetDetailsClient {

    public PetResponse UpdatepetWithID(PetRequest request)
    {
        UpdatePetDetailsEndpoint enpoint = new UpdatePetDetailsEndpoint(request);
        Response response = new Handler().requestHandler(enpoint);
        System.out.println(response.getBody().asString());
        PetResponse responseClass = response.as(PetResponse.class);
        String a = response.getBody().asString();
        responseClass.setHttpStatusCode(response.statusCode());
        return responseClass;
    }
}

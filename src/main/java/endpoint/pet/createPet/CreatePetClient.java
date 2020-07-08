package endpoint.pet.createPet;

import endpoint.pet.PetRequest;
import endpoint.pet.PetResponse;
import frame.Handler;
import io.restassured.response.Response;

public class CreatePetClient {

    public PetResponse createpetWithvalid(PetRequest request)
    {
        CreatePetEndpoint enpoint = new CreatePetEndpoint(request);
        Response response = new Handler().requestHandler(enpoint);
        PetResponse responseClass = response.as(PetResponse.class);
        responseClass.setHttpStatusCode(response.statusCode());
        return responseClass;
    }
}

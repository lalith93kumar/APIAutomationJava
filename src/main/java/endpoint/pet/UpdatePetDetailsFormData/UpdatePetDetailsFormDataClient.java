package endpoint.pet.UpdatePetDetailsFormData;

import endpoint.pet.PetRequest;
import endpoint.pet.PetResponse;
import frame.Handler;
import io.restassured.response.Response;

public class UpdatePetDetailsFormDataClient {

    public PetResponse UpdatepetWithIDFormData(PetRequest request)
    {
        UpdatePetDetailsFormDataEndpoint enpoint = new UpdatePetDetailsFormDataEndpoint(request);
        Response response = new Handler().requestHandler(enpoint);
        System.out.println(response.getBody().asString());
        PetResponse responseClass = new PetResponse();
        String a = response.getBody().asString();
        responseClass.setHttpStatusCode(response.statusCode());
        return responseClass;
    }
}

package endpoint.pet.deletePet;

import frame.Handler;
import frame.ResponseMetaData;
import io.restassured.response.Response;

public class DeletePetClient {

    public ResponseMetaData deletePetWithID(Long id)
    {
        DeletePetEndpoint deletePetEndpoint = new DeletePetEndpoint(id);
        Response response = new Handler().requestHandler(deletePetEndpoint);
        ResponseMetaData responseClass = new ResponseMetaData();
        responseClass.setHttpStatusCode(response.statusCode());
        return responseClass;
    }
}

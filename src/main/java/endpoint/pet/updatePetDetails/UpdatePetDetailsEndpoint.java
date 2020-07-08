package endpoint.pet.updatePetDetails;
import endpoint.PetStoreProperties;
import endpoint.pet.PetRequest;
import frame.HttpMethod;
import frame.Param;
import frame.ProtocalInterface;

import java.util.ArrayList;
import java.util.List;

public class UpdatePetDetailsEndpoint implements ProtocalInterface {
    private PetRequest request;
    public UpdatePetDetailsEndpoint(PetRequest request)
    {
        this.request = request;
    }
    @Override
    public String url() {
        return PetStoreProperties.propertiesReader.getEndPointUrl("update_pet");
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
    }

    @Override
    public List<Param> headers() {
        List<Param> header = new ArrayList<>();
        header.add(new Param("Content-Type", "application/json"));
        return header;
    }

    @Override
    public Object body() {
        return request;
    }

    @Override
    public List<Param> formParam() {
        return null;
    }
}

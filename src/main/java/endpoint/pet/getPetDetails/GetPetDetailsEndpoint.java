package endpoint.pet.getPetDetails;

import endpoint.PetStoreProperties;
import frame.HttpMethod;
import frame.Param;
import frame.ProtocalInterface;

import java.util.ArrayList;
import java.util.List;

public class GetPetDetailsEndpoint implements ProtocalInterface {

    private String id;
    public GetPetDetailsEndpoint(String id)
    {
        this.id = id;
    }
    @Override
    public String url() {
        return PetStoreProperties.propertiesReader.getEndPointUrl("get_pet");
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        List<Param> header = new ArrayList<>();
        header.add(new Param("id", id));
        return header;
    }

    @Override
    public List<Param> headers() {
        List<Param> header = new ArrayList<>();
        header.add(new Param("Content-Type", "application/json"));
        return header;
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public List<Param> formParam() {
        return null;
    }
}

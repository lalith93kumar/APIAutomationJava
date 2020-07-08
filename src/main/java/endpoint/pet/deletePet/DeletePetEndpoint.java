package endpoint.pet.deletePet;

import endpoint.PetStoreProperties;
import frame.HttpMethod;
import frame.Param;
import frame.ProtocalInterface;

import java.util.ArrayList;
import java.util.List;

public class DeletePetEndpoint implements ProtocalInterface {
    private Long id;
    @Override
    public String url() {
        return PetStoreProperties.propertiesReader.getEndPointUrl("delete_pet");
    }

    public DeletePetEndpoint(Long id)
    {
        this.id = id;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        List<Param>  pathparam = new ArrayList<>();
        pathparam.add(new Param("id", id.toString()));
        return pathparam;
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

package endpoint.pet.UpdatePetDetailsFormData;

import endpoint.PetStoreProperties;
import endpoint.pet.PetRequest;
import frame.HttpMethod;
import frame.Param;
import frame.ProtocalInterface;

import java.util.ArrayList;
import java.util.List;

public class UpdatePetDetailsFormDataEndpoint implements ProtocalInterface  {
    private PetRequest request;
    public UpdatePetDetailsFormDataEndpoint(PetRequest request)
    {
        this.request = request;
    }
    @Override
    public String url() {
        return PetStoreProperties.propertiesReader.getEndPointUrl("update_pet_form");
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        List<Param>  pathparam = new ArrayList<>();
        pathparam.add(new Param("id", request.getId().toString()));
        return pathparam;
    }

    @Override
    public List<Param> headers() {
        List<Param> header = new ArrayList<>();
        header.add(new Param("Content-Type", "application/x-www-form-urlencoded"));
        return header;
    }

    @Override
    public Object body() {
        return null;
    }

    @Override
    public List<Param> formParam() {
        List<Param> formdata = new ArrayList<>();
        if(request.getName()!=null)
            formdata.add(new Param("name", request.getName()));
        if(request.getStatus()!=null)
            formdata.add(new Param("status", request.getStatus()));
        return formdata;
    }
}

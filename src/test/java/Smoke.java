import endpoint.pet.PetRequest;
import endpoint.pet.PetResponse;
import endpoint.pet.UpdatePetDetailsFormData.UpdatePetDetailsFormDataClient;
import endpoint.pet.createPet.CreatePetClient;
import endpoint.pet.deletePet.DeletePetClient;
import endpoint.pet.getPetDetails.GetPetDetailsClient;
import endpoint.pet.updatePetDetails.UpdatePetDetailsClient;
import frame.ResponseMetaData;
import org.junit.Test;

import java.util.Arrays;

public class Smoke extends BaseTest {

    @Test
    public void createPet()
    {
        PetRequest request;
        request = PetRequest.builder()
                .name("dog1"+ get3DigitRandomInt())
                .status("available")
                .category(PetRequest.Category.builder().name("string").build())
                .photoUrls(Arrays.asList("string"))
                .tags(Arrays.asList(PetRequest.Tags.builder().name("string").build()))
                .build();
        PetResponse response = new CreatePetClient().createpetWithvalid(request);
        response.assertHttpStatusToBe(200);
        response.assertName(request.getName());
        response.assertStatus(request.getStatus());
        response.assertCategory(request.getCategory());
        response.assertTags(request.getTags());
        PetResponse getPetDetailsResponse = new GetPetDetailsClient().getPetDetailsByID(response.getId());
        getPetDetailsResponse.assertHttpStatusToBe(200);
        getPetDetailsResponse.assertName(request.getName());
        getPetDetailsResponse.assertStatus(request.getStatus());
        getPetDetailsResponse.assertCategory(request.getCategory());
        getPetDetailsResponse.assertTags(request.getTags());
    }

    @Test
    public void updatePetDetails()
    {
        PetRequest request;
        request = PetRequest.builder()
                .name("dog1"+ get3DigitRandomInt())
                .status("available")
                .category(PetRequest.Category.builder().name("string").build())
                .photoUrls(Arrays.asList("string"))
                .tags(Arrays.asList(PetRequest.Tags.builder().name("string").build()))
                .build();
        PetResponse response = new CreatePetClient().createpetWithvalid(request);
        response.assertHttpStatusToBe(200);
        PetRequest updaterequest = PetRequest.builder()
                .id(response.getId())
                .name("dog1"+ get3DigitRandomInt())
                .status("pending")
                .build();
        PetResponse udatePetDetailsResponse = new UpdatePetDetailsClient().UpdatepetWithID(updaterequest);
        udatePetDetailsResponse.assertHttpStatusToBe(200);
        udatePetDetailsResponse.assertName(updaterequest.getName());
        udatePetDetailsResponse.assertStatus(updaterequest.getStatus());
        PetResponse getPetDetailsResponse = new GetPetDetailsClient().getPetDetailsByID(response.getId());
        getPetDetailsResponse.assertHttpStatusToBe(200);
        getPetDetailsResponse.assertName(updaterequest.getName());
        getPetDetailsResponse.assertStatus(updaterequest.getStatus());
    }

    @Test
    public void updatePetDetailsWithFormData()
    {
        PetRequest request;
        request = PetRequest.builder()
                .name("dog1"+ get3DigitRandomInt())
                .status("available")
                .category(PetRequest.Category.builder().name("string").build())
                .photoUrls(Arrays.asList("string"))
                .tags(Arrays.asList(PetRequest.Tags.builder().name("string").build()))
                .build();
        PetResponse response = new CreatePetClient().createpetWithvalid(request);
        response.assertHttpStatusToBe(200);
        PetRequest updaterequest = PetRequest.builder()
                .id(response.getId())
                .name("dog1"+ get3DigitRandomInt())
                .status("pending")
                .build();
        PetResponse udatePetDetailsResponse = new UpdatePetDetailsFormDataClient().UpdatepetWithIDFormData(updaterequest);
        udatePetDetailsResponse.assertHttpStatusToBe(200);
        PetResponse getPetDetailsResponse = new GetPetDetailsClient().getPetDetailsByID(response.getId());
        getPetDetailsResponse.assertHttpStatusToBe(200);
        getPetDetailsResponse.assertName(updaterequest.getName());
        getPetDetailsResponse.assertStatus(updaterequest.getStatus());
    }

    @Test
    public void DeletePetDetailsWithID()
    {
        PetRequest request;
        request = PetRequest.builder()
                .name("dog1"+ get3DigitRandomInt())
                .status("available")
                .category(PetRequest.Category.builder().name("string").build())
                .photoUrls(Arrays.asList("string"))
                .tags(Arrays.asList(PetRequest.Tags.builder().name("string").build()))
                .build();
        PetResponse response = new CreatePetClient().createpetWithvalid(request);
        response.assertHttpStatusToBe(200);
        ResponseMetaData responseMetaData = new DeletePetClient().deletePetWithID(response.getId());
        responseMetaData.assertHttpStatusToBe(200);
        ResponseMetaData deletedPetDetailsResponse = new GetPetDetailsClient().getDeletedPetDetailsByID(response.getId());
        deletedPetDetailsResponse.assertHttpStatusToBe(404);
    }
}

package endpoint.pet;

import frame.ResponseMetaData;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PetResponse extends ResponseMetaData {
    private Long id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private String status;
    private List<Tags> tags;

    @Getter
    @Setter
    public static class Category{
        private Long id;
        private String name;
    }

    @Getter
    @Setter
    public static class Tags{
        private String name;
        private Long id;
    }

    public void assertTags(List<PetRequest.Tags> tags)
    {
        boolean flag = false;
        for (PetRequest.Tags tag:tags) {
            Assert.assertTrue(this.tags.stream().map(s -> s.getName()).collect(Collectors.toList()).contains(tag.getName()));
        }
    }

    public void assertCategory(PetRequest.Category category)
    {
        Assert.assertEquals("Invalid Category",category.getName(),this.category.getName());
    }

    public void assertStatus(String status)
    {
        Assert.assertEquals("Invalid status",status,getStatus());
    }

    public void assertName(String name)
    {
        Assert.assertEquals("Invalid name",name,getName());
    }
}

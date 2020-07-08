package endpoint.pet;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PetRequest {
    private Long id;
    private String name;
    private Category category;
    private List<String> photoUrls;
    private String status;
    private List<Tags> tags;

    @Getter
    @Setter
    @Builder
    public static class Category{
        private int id;
        private String name;
    }

    @Getter
    @Setter
    @Builder
    public static class Tags{
        private String name;
        private int id;
    }
}

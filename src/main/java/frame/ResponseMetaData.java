package frame;

import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;

@Getter
@Setter
public class ResponseMetaData {
    private int httpStatusCode;

    public void assertHttpStatusToBe(int httpStatusCode) {
        Assert.assertEquals("HTTP Status code is not matching", getHttpStatusCode(), httpStatusCode);
    }
}

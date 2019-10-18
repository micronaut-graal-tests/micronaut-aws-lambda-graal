package micronaut.aws.lambda.graal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.*;

@Controller("/")
public class PingController {
    private static final Logger LOG = LoggerFactory.getLogger(PingController.class);

    @Get("/ping")
    public String index() {
        return "{\"pong\":true, \"graal\": true}";
    }
}

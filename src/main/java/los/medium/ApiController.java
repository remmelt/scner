package los.medium;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import los.medium.svc.SceneService;

import java.sql.SQLException;

public class ApiController {
    private final SceneService sceneService = new SceneService();
    private final ObjectMapper mapper = new ObjectMapper();

    public ApiController() throws SQLException {
    }

    public String allScenes() throws JsonProcessingException, SQLException {
        return mapper.writeValueAsString(sceneService.scenes());
    }

    public String sceneById(Integer sceneId) throws SQLException, JsonProcessingException {
        return mapper.writeValueAsString(sceneService.sceneById(sceneId));
    }
}

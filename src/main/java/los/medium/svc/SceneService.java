package los.medium.svc;

import io.javalin.http.NotFoundResponse;
import los.medium.model.ImmutablePerson;
import los.medium.model.ImmutablePublisher;
import los.medium.model.ImmutableScene;
import los.medium.model.Person;
import los.medium.model.Publisher;
import los.medium.model.Scene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SceneService {
    private static final String CONNECTION_STRING = "jdbc:sqlite:/Users/remmelt/dev/side/scner/db/scner.db";

    private final Connection connection = DriverManager.getConnection(CONNECTION_STRING);

    public SceneService() throws SQLException {
    }

    public List<Scene> scenes() throws SQLException {
        final var sql = "select * from scenes";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        ResultSet rs = statement.executeQuery();

        var publisherMap = publisherMap();

        List<Scene> scenes = new ArrayList<>();
        while (rs.next()) {
            final var scene_id = rs.getInt("scene_id");
            var persons = personsBySceneId(scene_id);

            scenes.add(
                    ImmutableScene.builder()
                            .id(scene_id)
                            .name(rs.getString("name"))
                            .addAllPersons(persons)
                            .image(rs.getString("image"))
                            .thumbs(rs.getString("thumbs"))
                            .publisher(publisherMap.get(rs.getInt("publisher_id")))
                            .build());
        }
        return scenes;
    }

    public Scene sceneById(Integer sceneId) throws SQLException {
        final var sql = "select * from scenes where scene_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        statement.setInt(1, sceneId);

        ResultSet rs = statement.executeQuery();

        var publisherMap = publisherMap();

        while (rs.next()) {
            final var scene_id = rs.getInt("scene_id");
            var persons = personsBySceneId(scene_id);

            return ImmutableScene.builder()
                    .id(scene_id)
                    .name(rs.getString("name"))
                    .addAllPersons(persons)
                    .image(rs.getString("image"))
                    .thumbs(rs.getString("thumbs"))
                    .publisher(publisherMap.get(rs.getInt("publisher_id")))
                    .build();

        }
        throw new NotFoundResponse();
    }

    public List<Person> personsBySceneId(int sceneId) throws SQLException {
        String sql = "select * from persons p join appearances a on a.person_id = p.person_id where a.scene_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        statement.setInt(1, sceneId);

        ResultSet rs = statement.executeQuery();

        List<Person> persons = new ArrayList<>();
        while (rs.next()) {
            persons.add(
                    ImmutablePerson.builder()
                            .id(rs.getInt("scene_id"))
                            .name(rs.getString("name"))
                            .image(rs.getString("image"))
                            .build());
        }
        return persons;
    }

    public Map<Integer, Publisher> publisherMap() throws SQLException {
        String sql = "select * from publishers";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        Map<Integer, Publisher> result = new HashMap<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            result.put(rs.getInt("publisher_id"),
                    ImmutablePublisher.builder()
                            .id(rs.getInt("publisher_id"))
                            .name(rs.getString("name"))
                            .build()
            );
        }
        return result;
    }
}

package los.medium;

import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import io.javalin.http.staticfiles.Location;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        Javalin app = Javalin.create(Main::config).start();
        app.exception(Exception.class, (e, ctx) -> {
            log.warn("Found some exception", e);
            ctx.status(HttpStatus.INTERNAL_SERVER_ERROR_500);
        });

        final var apiController = new ApiController();
        app.get("scene/:scene_id", ctx -> ctx.result(
                apiController.sceneById(ctx.pathParam("scene_id", Integer.class).get())
        ));
        app.get("scene", ctx -> ctx.result(
                apiController.allScenes()
        ));
    }

    private static void config(JavalinConfig config) {
        config.requestLogger((ctx, ms) -> {
            log.debug("{} {} {} {}",
                    ctx.method(),
                    ctx.path(),
                    ctx.status(),
                    ms);
            if (ctx.resultString() != null) {
                log.debug(ctx.resultString());
            }
        });
        config.addStaticFiles("fe", Location.EXTERNAL);
        config.enableCorsForAllOrigins();
    }
}

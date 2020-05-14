package los.medium.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Value.Immutable
@Value.Style(stagedBuilder = true)
public abstract class Scene {
    @JsonProperty("id")
    public abstract Integer id();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("image")
    @Nullable
    public abstract String image();

    @JsonProperty("thumbs")
    @Nullable
    public abstract String thumbs();

    @JsonProperty("publisher")
    @Nullable
    public abstract Publisher publisher();

    @JsonProperty("persons")
    public abstract List<Person> persons();
}

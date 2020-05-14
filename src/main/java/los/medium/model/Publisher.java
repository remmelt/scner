package los.medium.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(stagedBuilder = true)
public abstract class Publisher {
    @JsonProperty("id")
    public abstract Integer id();

    @JsonProperty("name")
    public abstract String name();
}

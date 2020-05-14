package los.medium.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

@Value.Immutable
@Value.Style(stagedBuilder = true)
public abstract class Person {
    @JsonProperty("id")
    public abstract Integer id();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("image")
    @Nullable
    public abstract String image();
}

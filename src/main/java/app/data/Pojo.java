package app.data;

import org.immutables.gson.Gson;
import org.immutables.value.Value;

/**
 * This is just a sample data object, just remove.
 */
@Value.Immutable
@Value.Style(jdkOnly = true)
@Gson.TypeAdapters
public interface  Pojo {
  long id();
  String name();
}


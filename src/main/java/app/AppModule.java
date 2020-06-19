package app;

import app.endpoint.SomeGroupedEndpoints;
import app.scheduled.ScheduledSeconds;
import app.service.MessageService;
import com.github.apilab.core.Env;
import com.github.apilab.executors.Scheduled;
import com.github.apilab.queues.QueueService;
import com.github.apilab.rest.Endpoint;
import com.github.apilab.rest.auth.AuthConfiguration;
import com.github.apilab.rest.auth.ImmutableAuthConfiguration;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import static java.util.Collections.emptySet;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module
public class AppModule {

  @Provides
  @Singleton
  public Env env() {
    // Allowing to custom return an Env so that it can be mocked on tests.
    return new Env();
  }

  @Provides
  @Singleton
  public AuthConfiguration restInitializer() {
    // Essential role mapping configuration for authorization.
    return ImmutableAuthConfiguration.builder()
      .roleMapper(Roles::valueOf)
      .build();
  }

  @Provides
  @IntoSet
  public Endpoint getEndpoint(SomeGroupedEndpoints endpoint) {
    // A sample endpoint
    return endpoint;
  }

  // Remove this if you don't use jdbi/databases.
  @Provides
  @Named("jdbiImmutables")
  public Set<Class<?>> immutableClass() {
    return emptySet();
  }

  // Remove this if you don't use rabbitmq/queues
  @Provides
  @IntoSet
  public QueueService mesageService(MessageService service) {
    return service;
  }

  // Remove this if you don't use scheduler/executors.
  @Provides
  @IntoSet
  public Scheduled scheduledSeconds(ScheduledSeconds scheduled) {
    return scheduled;
  }

}

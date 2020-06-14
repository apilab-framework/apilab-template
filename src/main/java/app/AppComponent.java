package app;

import com.github.apilab.core.ApplicationLifecycle;
import com.github.apilab.core.GSONModule;
import com.github.apilab.executors.ExecutorsModule;
import com.github.apilab.jdbi.JdbiModule;
import com.github.apilab.rabbitmq.RabbitMQModule;
import com.github.apilab.rest.RESTModule;
import javax.inject.Singleton;

@dagger.Component(modules = {
  // Our own app module providing custom instances
  AppModule.class,
  // API-LAB modules, remove what you don't use.
  GSONModule.class,
  RESTModule.class,
  JdbiModule.class,
  RabbitMQModule.class,
  ExecutorsModule.class})
@Singleton
public interface AppComponent {
  ApplicationLifecycle instance();
}

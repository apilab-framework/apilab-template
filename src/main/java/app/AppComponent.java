package app;

import com.github.apilab.barehttp.BareHttpModule;
import com.github.apilab.core.ApplicationLifecycle;
import com.github.apilab.core.GSONModule;
import com.github.apilab.executors.ExecutorsModule;
import com.github.apilab.grpc.GRPCModule;
import com.github.apilab.jdbi.JdbiModule;
import com.github.apilab.prometheus.PrometheusModule;
import com.github.apilab.rabbitmq.QueueModule;
import com.github.apilab.rest.JavalinModule;
import javax.inject.Singleton;

@dagger.Component(modules = {
  // Our own app module providing custom instances
  AppModule.class,
  // API-LAB modules, remove what you don't use.
  GSONModule.class,
  BareHttpModule.class,
  PrometheusModule.class,
  JavalinModule.class,
  GRPCModule.class,
  JdbiModule.class,
  QueueModule.class,
  ExecutorsModule.class})
@Singleton
public interface AppComponent {
  ApplicationLifecycle instance();
}

package app.service;

import com.github.apilab.queues.QueueService;
import com.google.gson.Gson;
import com.rabbitmq.client.ConnectionFactory;
import javax.inject.Inject;

/**
 * This is part of the rabbitmq module and the queued async services.
 * Remove this class if you don't use that module.
 */
public class MessageService extends QueueService<String> {

  @Inject
  public MessageService(ConnectionFactory connectionFactory, Gson gson) {
    super(connectionFactory, gson, "messages", String.class);
  }

  @Override
  public void receive(String message) {
    System.out.println("Hello: "+message);
  }

}

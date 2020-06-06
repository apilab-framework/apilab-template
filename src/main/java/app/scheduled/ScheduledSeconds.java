package app.scheduled;

import app.service.MessageService;
import com.github.apilab.executors.Scheduled;
import javax.inject.Inject;

/**
 * This is part of the executors module, remove this class if you don't use that module.
 */
public class ScheduledSeconds implements Scheduled {

  @Inject MessageService messageService;

  @Inject
  public ScheduledSeconds() {
    ///
  }

  @Override
  public long period() {
    return 1000;
  }

  @Override
  public void run() {
    messageService.send("1 second passed.");
  }

}

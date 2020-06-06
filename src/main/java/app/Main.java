package app;

public class Main {
  public static void main(String[] args) {
    System.setProperty("API_ENABLE_ENDPOINTS", "true");
    System.setProperty("API_ENABLE_CONSUMERS", "true");
    System.setProperty("API_ENABLE_SCHEDULED", "true");
    System.setProperty("API_ENABLE_MIGRATION", "true");
    app.DaggerAppComponent
      .create()
      .instance()
      .start();
  }
}

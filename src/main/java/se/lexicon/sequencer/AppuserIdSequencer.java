package se.lexicon.sequencer;

public class AppuserIdSequencer {

  private static int sequencer = 1000;

  public static int nextId() {
    return ++sequencer;
  }
}

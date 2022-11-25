package se.lexicon.sequencer;

public class TodoItemIdSequencer {

  private static int sequencer = 0;

  public static int nextId() {
    return ++sequencer;
  }
}

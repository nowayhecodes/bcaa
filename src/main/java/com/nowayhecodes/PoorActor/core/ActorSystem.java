package com.nowayhecodes.PoorActor.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import com.nowayhecodes.PoorActor.core.ActorRef;

public class ActorSystem {
  private Map<String, ActorRef> registry = new HashMap<>();

  public ActorRef actor(String name, Consumer<Object> f) {
    ActorRef ref = new ActorRef(name);

    registry.put(name, ref);

    Thread t = new Thread(() -> {
      while (true) {
        if (ref.getLetterCount() == 0) Thread.sleep(10);
        f.accept(ref.getLetter());
      }
    });
    t.start();
    return ref;
  }

  public Optional<ActorRef> lookup(String name) {
    ActorRef ref = registry.get(name);
    return Optional.of(ref);
  }
}

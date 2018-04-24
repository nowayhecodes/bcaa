package com.nowayhecodes.PoorActor.core;

import com.nowayhecodes.PoorActor.core.ActorRef;
import com.nowayhecodes.PoorActor.core.ActorSystem;

public class Actor {
  public Actor(){  }

  ActorSystem system = new ActorSystem();

  ActorRef echoActor = system.actor("echo", (Object msg) -> {
    if (msg instanceof String) {
      System.out.println((String) msg);
    }
    echoActor.tell((String) "Hello");
  });

  ActorRef ping = system.actor("ping", (Object msg) -> {
    if (msg instanceof String) {
      String sMsg = (String) msg;
      if (sMsg.equals("ping")) {
        System.out.println("ping");
        system.lookup("pong").ifPresent((ActorRef pong) -> pong.tell("pong"));
      }
    }
  });

  ActorRef pong = system.actor("pong", (Object msg) -> {
    if (msg instanceof String) {
      String sMsg = (String) msg;
      if (sMsg.equals("pong")) {
        System.out.println("pong");
        system.lookup("ping").ifPresent((ActorRef ping) -> ping.tell("ping"));
      }
    }
  });

}

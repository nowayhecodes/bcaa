package com.nowayhecodes.PoorActor.core;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ActorRef implements Runnable {
  private ConcurrentLinkedQueue<Object> mailbox = new ConcurrentLinkedQueue<>();
  private String name;

  public ActorRef(String name){
    this.name = name;
  }

  public void tell(Object msg){
    mailbox.offer(msg);
  }

  public Object getLetter(){
    return mailbox.poll();
  }

  public int getLetterCount(){
    return mailbox.size();
  }

  @Override
  public void run(){
    tell();
  }

}

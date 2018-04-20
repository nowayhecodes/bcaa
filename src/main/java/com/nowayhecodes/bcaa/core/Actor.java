final ConcurrentLinkedQueue<Object> mailbox = new ConcurrentLinkedQueue<>();

Thread actor = new Thread(() -> {
    while (true) {
        Thread.sleep(10);

        Object msg = mailbox.poll();

        if (msg == null) {
            continue;
        }
    
        try {
            // process message
        } catch (Exception e) {
            // handle exception(s)
        }
    }
});

actor.start();
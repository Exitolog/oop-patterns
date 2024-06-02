package patterns.behavioral.pubsub.task.pubsub;

public interface Listener<T> {
    void process(Event<T> event);
}

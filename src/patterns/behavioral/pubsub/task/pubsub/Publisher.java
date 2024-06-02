package patterns.behavioral.pubsub.task.pubsub;

public interface Publisher <T>{
    void registerSubscriber(Listener<T> listner);
    void unregisterSubscriber(Listener<T> listner);
    void notifySubscriber(Event<T> event);


}

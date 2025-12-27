# Observer Pattern - Class Diagram

This diagram illustrates the Observer pattern implementation in the observable package.

```mermaid
classDiagram
    class Observable {
        <<abstract>>
        -List~Observer~ observerList
        +subscribe(Observer observer)
        +unsubscribe(Observer observer)
        +notifyIt()
    }
    
    class Observer {
        <<interface>>
        +update(Observable observable)
    }
    
    class Termometre {
        -Double currentSicaklik
        -Double minSicaklik
        -Double maxSicaklik
        +Termometre(Double minSicaklik, Double maxSicaklik)
        +getCurrentSicaklik() Double
        +setCurrentSicaklik(Double currentSicaklik)
        -checkTemperature()
    }
    
    class Subscriber {
        -String name
        +Subscriber(String name)
        +update(Observable observable)
    }
    
    class Client {
        +main(String[] args)
    }
    
    Observable <|-- Termometre : extends
    Observer <|.. Subscriber : implements
    Observable "1" *-- "many" Observer : contains
    Client ..> Termometre : uses
    Client ..> Subscriber : creates
    Termometre ..|> Observer : notifies via
```

## Sequence Diagram

The following sequence diagram shows the interaction flow when temperature changes:

```mermaid
sequenceDiagram
    participant Client
    participant Termometre
    participant Observable
    participant Subscriber as Subscriber (Anne)
    
    Client->>Termometre: new Termometre(min, max)
    Client->>Subscriber: new Subscriber("Anne")
    Client->>Termometre: subscribe(anne)
    Termometre->>Observable: subscribe(consumer)
    
    Client->>Termometre: setCurrentSicaklik(temperature)
    Termometre->>Termometre: checkTemperature()
    alt Temperature >= max OR Temperature <= min
        Termometre->>Observable: notifyIt()
        Observable->>Subscriber: update(this)
        Subscriber->>Subscriber: System.out.println(name + " : " + temperature)
    end
```


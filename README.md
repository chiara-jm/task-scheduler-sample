# Task Scheduler Sample app

### Summary

This sample <b>Task Scheduler</b> was made as a showcase for a MVP-VM based architecture, using Dagger for DI and a [Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html) approach for UseCase execution.

### Architecture

The <b>Domain Layer</b> classes are inspired by the principles of [Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html).

The <b>Presentation Layer</b> implements the MVP-VM pattern that is an evolution of the [MVP Pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) by adding a ViewModel to extract the responsibility of binding model to view and gathering the input data to deliver it back to the presenter whenever it is needed.

The Data Layer is not intended to be covered on this example and you could use whatever architecture fit you the best. For this basic example I used a simple in memory repository that has the ability to deliver updates through java RX.

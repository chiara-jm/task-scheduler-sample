# Task Scheduler Sample app

### Summary

This sample <b>Task Scheduler</b> demostrate how to use [android-clean](https://github.com/chiara-jm/android-clean) and [android-mvp-vm](https://github.com/chiara-jm/android-mvp-vm) together to develope clean, simple and fast code.

It depends on [android-mvp-vm-ui](https://github.com/chiara-jm/android-mvp-vm-ui) library which solves problems of implementing MVP on Android specific UI (such as how to work with RecyclerView and Adapters).

Finally it uses [android-bindings](https://github.com/chiara-jm/android-bindings) library that give some extra [bindings adapters](https://developer.android.com/topic/libraries/data-binding/index.html#custom_setters) needed by the app.

### Architecture

The <b>[Domain Layer](https://github.com/chiara-jm/android-clean)</b> chiarajm.android.base classes are inspired by the principles of [Clean Architecture](https://blog.8thlight.com/uncle-bob/2012/08/13/the-clean-architecture.html).

The <b>[Presentation Layer](https://github.com/chiara-jm/android-mvp)</b> implements the MVP-VM pattern that is an evolution of the [MVP Pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) by adding a ViewModel to extract the responsibility of binding model to view and gathering the input data to deliver it back to the presenter whenever it is needed.

The Data Layer is not intended to be covered on this example and you could use whatever architecture fit you the best. For this basic example I used a simple in memory repository that has the ability to deliver updates through java RX.

<center><img src="https://goo.gl/H0l4Kh" alt="Diagram"/></center>

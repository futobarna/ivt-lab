# IVT Spaceship

This is a sample application for the [Integration and Verification Techniques](http://www.mit.bme.hu/oktatas/targyak/vimiac04) course at BME MIT.

The application is simplified and deliberately contains bugs.

## Getting started

- The project is implemented in Java 8.
- The project can be built using [Maven](https://maven.apache.org/).
- [JUnit](http://junit.org/junit4/) is used for tests, and [Mockito](http://site.mockito.org/) for isolating dependencies.

Clone the repository and execute Maven to build the application:

```
mvn compile
```

To compile and run tests also execute:

```
mvn test
```

(That will be enough to know for the current exercises. If you are more interested, see [this](https://github.com/FTSRG/swsv-labs/wiki/0b-Build-tools) short guide about Maven.)

As this is a really simple project, you can use the command-line build tool and a light-weight IDE like the [Atom](https://atom.io/) editor. Just be sure to enable collapsing directories (_File / Settings / Packages / tree-view / Collapse directories_).

## Overview

The project represents an alpha version of a spaceship.

- The ship (`SpaceShip` interface) can fire one or more lasers or torpedos.
- We have only one spaceship as of now (`GT4500`).
- Currently two firing modes (`FiringMode`) are supported: firing only one or all instances of a given weapon type.
- Lasers are not yet implemented, but the code for torpedo stores are ready (`TorpedoStore`).
- For the GT4500 ship the rules for firing torpedoes can be found in the Javadoc comment of method `fireTorpedos`. They are already partially implemented.
- There are currently 2 tests (`GT4500Test`), but be aware that they are not proper unit tests, as they do not isolate the dependencies of the tested class.

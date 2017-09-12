[![Build Status](https://travis-ci.org/vavr-io/vavr-kotlin.png)](https://travis-ci.org/vavr-io/vavr-kotlin)
[![codecov](https://codecov.io/gh/vavr-io/vavr-kotlin/branch/master/graph/badge.svg)](https://codecov.io/gh/vavr-io/vavr-kotlin)

# Vavr Kotlin

Vavr Kotlin is a set of Kotlin niceties for the [Vavr](http://vavr.io) functional collections library:
- idiomatic factory methods
- extension forms of `sequence`
- conversions to and from Kotlin collections

## Usage

Import Vavr Kotlin as follows:
```kotlin
import io.vavr.kotlin.*
```

Profit:
```kotlin
val optionOf: Option<Seq<Int>> = list(option(1), option(2), option(null)).sequence()
```

See the [Wiki](https://github.com/vavr-io/vavr-kotlin/wiki) for detailed API.

# JΛVΛSLΛNG Kotlin

JΛVΛSLΛNG Kotlin is a set of Kotlin niceties for the (JΛVΛSLΛNG)[javaslang.io] functional collections library.

Niceties include:
- factory methods with names more unique than `of`
- extension methods as appropriate
- conversions to and from Kotlin collections

## Usage
Import JΛVΛSLΛNG Kotlin as follows:
```kotlin
    import javaslang.kotlin.*
```
Profit:
```kotlin
    val optionOf: Option<Seq<Int>> = list(option(1), option(2), option(null)).sequence()
```
See the (Wiki)[https://github.com/javaslang/javaslang-kotlin/wiki] for detailed API.

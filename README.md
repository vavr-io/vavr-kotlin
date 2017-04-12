# Javaslang Kotlin

Javaslang Kotlin is a set of Kotlin niceties for the Javaslang functional collections library.

Niceties include:
- factory methods with more unique names than `of`
- extension methods as appropriate
- conversions to and from Kotlin collections

## Usage
Import Javaslang Kotlin as follows:
```kotlin
    import javaslang.kotlin.*
```

## Tuple

Tuples can be made as follows:
```kotlin
    val oneTuple = tuple(1)
    val twoTuple = tuple(1, "2")
    val threeTuple = tuple(1, "2", false)
    //  ... all the way to an 8-tuple
```

One-tuples can also be created directly from any object:
```kotlin
    val oneTuple = 1.tuple()
```

Two-tuples can also be created from, and converted to Kotlin `Pair`s:
```kotlin
    val twoTuple = (1 to "2").tuple()
    val twoPair = twoTuple.pair()
```

A Kotlin `Iterable` of any arity `Tuple`s can be sequenced as follows:
 ```kotlin
    val tupleOfSeqs: Tuple2<Seq<Int>, Seq<String>> = listOf(tuple(1, "2"), tuple(3, "4")).sequence()
```

> - Kotlin `Iterable`s are type alises for Java `Iterable`s 
> - everything in Javaslang derives from `Value`, which is a Java `Iterable`
> - ergo, everything in Javaslang is a Kotlin `Iterable`

## List

An ad-hoc Javaslang list can be created as follows:
```kotlin
    val list = list(1, 2, 3)
```

A Javaslang list can be converted to a Kotlin `MutableList`:
```kotlin
    val mutableList = list(1, 2, 3).toMutableList()
```

A Kotlin `Iterable` can be converted to a Javaslang `List`:
```kotlin
    val jsList = listOf(1, 2, 3).toJsList()
```

## Option

Kotlin has first-class nullables, so the `Option` constructor can be null-aware:
```kotlin
    val nada: None = option(null)
    val bonus: Some<Int> = option(1)
```

`Option`s can be predicated on a boolean value using a value or a factory method:
```kotlin
    val nada: None = false.option("Fabulous expression of beauty")
    val bonus: Some<String> = true.option("Bathroom poetry")
    
    val nadaFun: None = false.option { -> "Fabulous expression of beauty"}
    val bonusFun: Some<String> = true.option { -> "Bathroom poetry"}
```

A Kotlin `Iterable` of `Option`s can be sequenced as follows:
```kotlin
    val optionOfList: Option<Seq<Int>> = listOf(option(1), option(null)).sequence()
```

## Try
An ad-hoc `Try` can be created the usual way:
```kotlin
    val succes = success(1)
    val failure = failure(UnsupportedOperationException())
```

A lambda can be `Try`'d as follows:
```kotlin
    val success = `try` { ->
        "the quick brown fox jumps over the lazy dog"
    }
    val fail = `try` {
       throw UnsupportedOperationException()
    }
```

A Kotlin `Iterable` of `Try`s can be sequenced as follows: 
```kotlin
   val tryOfSeqs: Try<Seq<Int>> = listOf(success(1), failure(java.lang.NumberFormatException())).sequence()
```
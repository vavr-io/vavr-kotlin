# JΛVΛSLΛNG Kotlin

JΛVΛSLΛNG Kotlin is a set of Kotlin niceties for the Javaslang functional collections library.

Niceties include:
- factory methods with names more unique than `of`
- extension methods as appropriate
- conversions to and from Kotlin collections

## Usage
Import JΛVΛSLΛNG Kotlin as follows:
```kotlin
    import javaslang.kotlin.*
```

## Tuples

Tuples can be made as follows:
```kotlin
    val oneTuple = tuple(1)
    val twoTuple = tuple(1, "2")
    val threeTuple = tuple(1, "2", false)
    //  ... all the way to an 8-tuple
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

> NOTE:
> - the Kotlin `Iterable` is a type alias for the Java `Iterable` 
> - the JΛVΛSLΛNG super-class `Value` is a Java `Iterable`
> - ergo, _everything_ in JΛVΛSLΛNG is a Kotlin `Iterable`

## Collections

#### List

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

#### Set
Ad-hoc Javaslang sets can be created as follows:
```kotlin
    val hashSet = hashSet(1, 2, 3)
    val linkedHashSet = linkedHashSet("slow", "beige", "cat")
    val treeSet = treeSet("this string", "is less than", "that string")
```
> NOTE: elements of a TreeSet must be Comparable

A Javaslang Set can be converted to a Kotlin `MutableSet`:
```kotlin
    val mutableSet = hashSet(1, 2, 3).toMutableSet()
```

A Kotlin `Set` can be converted to a Javaslang `Set`:
```kotlin
    val jsList = listOf(1, 2, 3).toJsSet()
```

#### Map
Ad-hoc Javaslang maps can be created as follows:
```kotlin
    val hashSet = hashMap(1 to 1, 2 to 2, 3 to 3)
    val linkedHashMap = linkedHashMaphashMap(1 to "none", 2 to "a couple", 3 to "a lot")
    val treeMap = treeMap("this string" to 1, "is less than" to 2, "that string" to 3)
```
> NOTE: keys in a TreeMap must be Comparable

A Javaslang Map can be converted to a Kotlin `MutableMap`:
```kotlin
    val mutableMap = hashMap(1 to 1, 2 to 2, 3 to 3).toMutableMap()
```

A Kotlin `Map` can be converted to a Javaslang `Map`:
```kotlin
    val jsMap  = mapOf(1 to 1, 2 to 2, 3 to 3).toJsMap()
```

## Control Monads

#### Option

Kotlin has first-class nullables, so the `Option` constructor can be null-aware:
```kotlin
    val nada: None = option(null)
    val bonus: Some<Int> = option(1)
```

An ad-hoc `Option` can also be created in the usual way:
```kotlin
    val none = none()
    val some = some("well, there's that")
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
    val optionOfSeq: Option<Seq<Int>> = listOf(option(1), option(null)).sequence()
```

#### Try
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
   val tryOfSeqs: Try<Seq<Int>> = listOf(success(1), failure(NumberFormatException())).sequence()
```

#### Validation
An ad-hoc validation can be created the usual way:
```kotlin
    val invalid: Validation<Tuple2<Int, Int>, String> = invalid("your value sucks")
    val valid: Validation<Tuple2<Int, Int>, String> = valid(tuple(7, 11))
```

A Kotlin `Iterable` of `Validation`s can be sequenced as follows:
```kotlin
    val validOfSeq: Validation<List<Int>, Seq<String>> = listOf(valid(1), invalid("not one at all")).sequence()
```

#### Either
An ad-hoc `Either` can be created the usual way:
```kotlin
    val left: Either<Int, String> = left("wrong")
    val right: Either<Int, String> = right(1)
```

An `Either` can be converted into a `Validation`:
```kotlin
    val valid: Validation<Int, String> = right(1).validation()
    val invalid: Validation<Int, String> = left("your value still sucks").validation()
```

A Kotlin `Iterable` of `Either`s can be sequenced as follows:
```kotlin
    val eitherOfSeq: Either<List<Int>, Seq<String>> = listOf(left("still does"), right(1)).sequence() 
```
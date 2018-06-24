# Code Snippets

## Coordinates

#### Conversion between 1 and 2 dimensional space

```kotlin
  val rowSize = 10
  
  fun indexToCoord(idx: Int): Pair<Int, Int> {
    val x = idx % rowSize
    val y = idx / rowSize
    return x to y
  }
  
  fun coordToIndex(x: Int, y: Int): Int {
    return x + y * rowSize
  }
```

#### Point on a circle

```kotlin
  fun pointOnCircle(centerX: Int, centerY: Int, radius: Int, degree: Int): Pair<Int, Int> {   
    var x = (radius * Math.cos(degree * Math.PI / 180f) + centerX).toInt()
    var y = (radius * Math.sin(degree * Math.PI / 180f) + centerY).toInt()
    
    return x to y
  }
```

#### Angle from point to point

```kotlin
  fun angleTo(x1: Int, y1: Int, x2: Int, y2: Int): Int {
    return Math.toDegrees(Math.atan2((y2 - y1).toDouble(), (x2 - x1).toDouble())).toInt()
  }
```


## Game loop

```kotlin

```

## Links

[https://gamedev.stackexchange.com/questions/117250/movement-appears-to-be-frame-rate-dependent-despite-use-of-time-deltatime/117256#117256](FPS indpendent logic)

[https://www.redblobgames.com/grids/hexagons/](Coding with hexagons)

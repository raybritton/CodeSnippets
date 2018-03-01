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

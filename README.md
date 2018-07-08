# Game Code Snippets

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

## Game loop

```kotlin
  while (running) {
    var c: Canvas? = null
    try {
        c = holder.lockCanvas(null)
        synchronized(holder) {
            now = System.nanoTime()
            unprocessed += (now - last) / 16666666.66667
            last = now
            while (unprocessed >= 1) {
                unprocessed--
                updates++
                delta = (System.currentTimeMillis() - lastTick).toFloat() / 1000f
                lastUpdate = System.currentTimeMillis()

                update(System.currentTimeMillis() - appStartTime, delta)
            }

            try {
                Thread.sleep(sleepTime)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            
            frames++
            render(c, System.currentTimeMillis())

            if (nextLogTime < System.currentTimeMillis()) {
                lastFps = "F:$frames U: $updates"
                nextLogTime = System.currentTimeMillis() + 1000
                frames = 0
                updates = 0
            }

            if (showFps) {
                c.drawText(lastFps, (width - 100).toFloat(), 60f, fpsPaint)
            }
        }
    } finally {
        if (c != null) {
            holder!!.unlockCanvasAndPost(c)
        }
    }
  }
```

## Links

[FPS indpendent logic](https://gamedev.stackexchange.com/questions/117250/movement-appears-to-be-frame-rate-dependent-despite-use-of-time-deltatime/117256#117256)

[Coding with hexagons](https://www.redblobgames.com/grids/hexagons/) and [red blob games generally](https://www.redblobgames.com/)

package ru.s4nchez.recyclerwithselection

object Throttle {

    private val funcMap = HashMap<String, Long>()

    fun run(tag: String, func: () -> Unit, time: Long) {
        val timeNow = System.currentTimeMillis()
        if (funcMap.containsKey(tag)) {
            val lastTime = funcMap[tag] ?: timeNow
            if ((lastTime + time) < timeNow) {
                func.invoke()
                funcMap[tag] = timeNow
            }
        } else {
            funcMap[tag] = timeNow
            func.invoke()
        }
    }

    fun remove(tag: String) {
        funcMap.remove(tag)
    }
}
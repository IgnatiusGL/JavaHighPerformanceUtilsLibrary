package top.ignatiusgl.time;

import static top.ignatiusgl.time.TimeUnit.SECONDS;

/**
 * @Description: Statistical elapsed time
 * Simple Use:
 * Timer timer = Timer.startTimer();
 * // do something
 * timer.stop
 * System.out.println("time:" + timer.elapsed())
 *
 * If use stop() and continue use start(). The time will accumulate.
 * For example:
 * start() -----10s-----> stop()
 * start() -----15s-----> stop()
 * The elapsed(TimeUnit.SECONDS) will return 25 not 15
 * If you want to restart the timer, you need clear() or Timer.startTimer() to create a new Timer instance
 * @author: IgnatiusGL
 * @date: 2021-03-04 14:22
 */
public class Timer {
    private long startTime = -1;
    private long elapsed;

    private Timer() {
    }

    public static Timer startTimer() {
        Timer timer = new Timer();
        timer.start();
        return timer;
    }

    public void start() {
        if (startTime != -1) {
            throw new IllegalStateException("You already start the timer");
        }
        startTime = System.nanoTime();
    }

    public void stop() {
        elapsed += System.nanoTime() - startTime;
        startTime = -1;
    }

    public double elapsed() {
        return elapsed(SECONDS);
    }

    public double elapsed(TimeUnit timeUnit) {
        switch (timeUnit) {
            case NANOSECOND:
                return elapsed;
            case MILLISECOND:
                return elapsed / 1000.0;
            case SECONDS:
                return elapsed / 1000.0 / 1000;
            case MINUTES:
                return elapsed / 1000.0 / 1000 / 1000;
            case HOUR:
                return elapsed / 1000.0 / 1000 / 1000 / 1000;
            default:
                return -1L;
        }
    }

    public void clear() {
        elapsed = 0;
    }
}

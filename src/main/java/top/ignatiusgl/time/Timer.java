package top.ignatiusgl.time;

import top.ignatiusgl.exception.IllegalStateException;

import static top.ignatiusgl.time.TimeUnit.SECONDS;

/**
 * @Description: Statistical elapsed time.
 * Simple Use:
 * Timer timer = Timer.startTimer();
 * // do something
 * timer.stop;
 * System.out.println("time:" + timer.elapsed());
 * <p>
 * If use stop() and continue use start(). The time will accumulate.
 * For example:
 * start() -----10s-----> stop()
 * start() -----15s-----> stop()
 * The elapsed(TimeUnit.SECONDS) will return 25 not 15.
 * If you want to restart the timer, you need clear() or Timer.startTimer() to create a new Timer instance.
 * @author: IgnatiusGL
 * @date: 2021-03-04 14:22
 */
public class Timer {
    private long startTime = -1;
    private long elapsed;

    private Timer() {
    }

    /**
     * Return a timer instance and start the timer.
     *
     * @return Timer instance.
     */
    public static Timer startTimer() {
        Timer timer = new Timer();
        timer.start();
        return timer;
    }

    /**
     * Start the timer.
     */
    public void start() {
        if (startTime != -1) {
            throw new IllegalStateException("You already start the timer");
        }
        startTime = System.nanoTime();
    }

    /**
     * Stop the timer.
     */
    public void stop() {
        if (startTime == -1) {
            throw new IllegalStateException("The timer already stop");
        }
        elapsed += System.nanoTime() - startTime;
        startTime = -1;
    }

    /**
     * Get the Timer time elapsed.
     *
     * @return Time unit seconds.
     */
    public double elapsed() {
        return elapsed(SECONDS);
    }

    /**
     * Get the Timer time elapsed by time unit.
     *
     * @return Time.
     */
    public double elapsed(TimeUnit timeUnit) {
        if (startTime != -1) {
            throw new IllegalStateException("You must stop the timer before elapsed");
        }

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

    /**
     * Clear the Timer time.
     */
    public void clear() {
        if (startTime != -1) {
            throw new IllegalStateException("CLear don't run on the timer starting");
        }
        elapsed = 0;
    }
}

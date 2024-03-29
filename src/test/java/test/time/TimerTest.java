package test.time;

import org.junit.jupiter.api.Test;
import top.ignatiusgl.exception.IllegalStateException;
import top.ignatiusgl.time.TimeUnit;
import top.ignatiusgl.time.Timer;

/**
 * @Description: Test the Timer
 * @author: IgnatiusGL
 * @date: 2021-03-04 14:50
 */
public class TimerTest {
    @Test
    public void testBasic() throws InterruptedException {
        Timer timer = Timer.startTimer();
        Thread.sleep(1000);
        timer.stop();
        System.out.println("time:" + timer.elapsed() + " s");
        timer.start();
        Thread.sleep(2000);
        timer.stop();
        System.out.println("time:" + timer.elapsed(TimeUnit.SECONDS) + " s");
        System.out.println("time:" + timer.elapsed(TimeUnit.MILLISECOND) + " ms");

        timer.clear();
        timer.start();
        Thread.sleep(2000);
        timer.stop();
        System.out.println("time:" + timer.elapsed(TimeUnit.SECONDS) + " s");
        System.out.println("time:" + timer.elapsed(TimeUnit.SECONDS) + " ms");
    }

    @Test
    public void testException() throws InterruptedException {
        Timer timer = Timer.startTimer();

        try {
            timer.start();
        } catch (IllegalStateException e) {
            System.out.println("Exception:" + e.getMessage());
        }

        Thread.sleep(1000);
        try {
            timer.elapsed();
        } catch (IllegalStateException e) {
            System.out.println("Exception:" + e.getMessage());
        }
        try {
            timer.clear();
        } catch (IllegalStateException e) {
            System.out.println("Exception:" + e.getMessage());
        }

        timer.stop();

        try {
            timer.stop();
        } catch (IllegalStateException e) {
            System.out.println("Exception:" + e.getMessage());
        }

    }
}

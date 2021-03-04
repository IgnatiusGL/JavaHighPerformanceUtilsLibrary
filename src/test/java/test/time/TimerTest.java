package test.time;

import org.junit.jupiter.api.Test;
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
        System.out.println("time:" + timer.elapsed());
        timer.start();
        Thread.sleep(2000);
        timer.stop();
        System.out.println("time:" + timer.elapsed(TimeUnit.SECONDS));
    }
}

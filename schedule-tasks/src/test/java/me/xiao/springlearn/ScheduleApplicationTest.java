package me.xiao.springlearn;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 *
 * @author BaoQiang
 * @version 2.0
 * @date: 2017/8/4 16:20
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleApplicationTest {
    @Autowired
    private ScheduledTasks tasks;

    public void contextLoads(){
        assertThat(tasks).isNotNull();
    }

}
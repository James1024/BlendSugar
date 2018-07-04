package colin.com.blendsugar.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by wanglirong on 2017/06/17.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}

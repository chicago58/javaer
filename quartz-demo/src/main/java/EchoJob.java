import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoJob implements Job {
    private static Logger log = LoggerFactory.getLogger(EchoJob.class);

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("echo: 入门例子");
    }
}

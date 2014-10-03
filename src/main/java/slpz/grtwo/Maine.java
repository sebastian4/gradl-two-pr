package slpz.grtwo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Maine {
    
    public static void main(String[] args) {
        System.out.println("hello world gradl-two-pr");
        
        //greetExample();
        mkyong21Example();
    }
    
    public static void greetExample() {
        System.out.println("gradl-two-pr greetExample");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("job-hello-world.xml");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

        Job job = (Job) context.getBean("helloWorldJob");

        try {
			jobLauncher.run(job, new JobParameters());
			
		} catch (JobExecutionAlreadyRunningException | JobRestartException
				| JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			System.out.println("there was an error in gradl-two-pr");
			e.printStackTrace();
		}
    }
    
    public static void mkyong21Example() {
        System.out.println("gradl-two-pr mkyong21Example");
        
        String[] springConfig = { "job-read-files.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("readMultiFileJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());

		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("Done");
    }
}

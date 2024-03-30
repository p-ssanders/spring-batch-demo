package dev.samsanders.demo.batchdemo.job.helloworld;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HelloWorldJobConfiguration {

    @Bean
    Job helloWorldJob(JobRepository jobRepository, Step sayHelloStep) {
        return new JobBuilder("hello-world", jobRepository)
                .start(sayHelloStep)
                .build();
    }

    @Bean
    Step sayHelloStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, Tasklet helloWorldTasklet) {
        return new StepBuilder("say-hello", jobRepository).tasklet(helloWorldTasklet, platformTransactionManager).build();
    }

    @Bean
    Tasklet helloWorldTasklet(@Value("${to-whom:world}") String helloTo) {
        return new HelloWorldTasklet(helloTo);
    }

}

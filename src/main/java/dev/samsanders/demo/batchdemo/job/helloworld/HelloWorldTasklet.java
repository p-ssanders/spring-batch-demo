package dev.samsanders.demo.batchdemo.job.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Objects;

class HelloWorldTasklet implements Tasklet {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldTasklet.class);
    private final String helloTo;

    public HelloWorldTasklet(String helloTo) {
        this.helloTo = helloTo;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        logger.info("Hello %s".formatted(helloTo));
        return RepeatStatus.FINISHED;
    }
}

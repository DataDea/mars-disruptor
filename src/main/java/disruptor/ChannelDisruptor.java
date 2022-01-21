package disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import event.AbstractEventFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 11:09
 */
public class ChannelDisruptor<T> {

    private final Integer ringBufferSize;
    private final Integer workHandler;
    private final Disruptor<T> disruptor;

    public ChannelDisruptor(Integer ringBufferSize,
                            Integer workHandler,
                            AbstractEventFactory<T> factory,
                            EventHandler<T> handler) {
        this.ringBufferSize = ringBufferSize;
        this.workHandler = workHandler;
        if (null == ringBufferSize) {
            ringBufferSize = 4096;
        }
        if (null == workHandler) {
            workHandler = 8;
        }
        YieldingWaitStrategy yieldingWaitStrategy = new YieldingWaitStrategy();
        ExecutorService executorService = Executors.newFixedThreadPool(workHandler);
        disruptor = new Disruptor<>(factory, ringBufferSize, executorService, ProducerType.MULTI, yieldingWaitStrategy);
        disruptor.handleEventsWith(handler);
    }

    public Integer getRingBufferSize() {
        return ringBufferSize;
    }

    public Integer getWorkHandler() {
        return workHandler;
    }

    public Disruptor<T> getDisruptor() {
        return disruptor;
    }

    public Disruptor<T> start() {
        this.disruptor.start();
        return this.disruptor;
    }

    public void publisher(EventTranslator<T> event) {
        try {
            this.disruptor.getRingBuffer().tryPublishEvent(event);
        } catch (Exception e) {

        }
    }
}

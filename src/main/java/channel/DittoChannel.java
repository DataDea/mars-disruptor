package channel;

import com.lmax.disruptor.RingBuffer;
import disruptor.ChannelDisruptor;
import disruptor.DittoEventHandler;
import event.DittoEvent;
import event.DittoEventFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 13:35
 */
public class DittoChannel {

    public static void main(String[] args) {
        DittoEventFactory dittoEventFactory = new DittoEventFactory();
        DittoEventHandler dittoEventHandler = new DittoEventHandler();
        ChannelDisruptor<DittoEvent> dittoEventChannelDisruptor = new ChannelDisruptor<>(1024, 8, dittoEventFactory, dittoEventHandler);
        RingBuffer<DittoEvent> ringBuffer = dittoEventChannelDisruptor.start();
        AtomicLong incr = new AtomicLong(0);
        for (; ; ) {
            long cursor = ringBuffer.getCursor();
            System.out.println("cursor is " + cursor);
            DittoEvent instance = DittoEvent.INSTANCE;
            instance.setBody(String.valueOf(incr.incrementAndGet()));
            dittoEventChannelDisruptor.publisher(instance);
        }
    }
}

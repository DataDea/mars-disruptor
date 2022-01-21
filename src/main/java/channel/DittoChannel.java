package channel;

import disruptor.ChannelDisruptor;
import disruptor.DittoEventHandler;
import event.DittoEvent;
import event.DittoEventFactory;

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
        ChannelDisruptor<DittoEvent> dittoEventChannelDisruptor  = new ChannelDisruptor<>(1024, 8, dittoEventFactory, dittoEventHandler);
        dittoEventChannelDisruptor.start();
        for (;;) {
            dittoEventChannelDisruptor.publisher(DittoEvent.INSTANCE);
        }
    }
}
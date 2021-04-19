package disruptor;

import com.lmax.disruptor.EventHandler;
import event.LongEvent;

/**
 * @author yanghai
 * @since 2021/4/13-下午7:02
 **/
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}

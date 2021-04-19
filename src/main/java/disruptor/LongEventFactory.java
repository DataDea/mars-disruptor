package disruptor;

import com.lmax.disruptor.EventFactory;
import event.LongEvent;

/**
 * @author yanghai
 * @since 2021/4/13-下午7:00
 **/
public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}

package event;

import com.lmax.disruptor.EventFactory;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 10:46
 */
public interface AbstractEventFactory<T> extends EventFactory<T> {

    T newInstance();
}

package event;

import lombok.Data;

/**
 * @author yanghai10
 * @ClassName DittoEvent
 * @Description DITTOevnet
 * @date 2022/1/21 10:45
 */
@Data
public class DittoEvent extends AbstractEvent {

    private DittoEvent() {

    }

    public final static DittoEvent INSTANCE = new DittoEvent();

    private static final long serialVersionUID = -6112919782126994308L;

    private String body;

    @Override
    public void translateTo(Object event, long sequence) {

    }
}

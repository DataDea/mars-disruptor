package disruptor;


import com.lmax.disruptor.EventHandler;
import event.DittoEvent;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 13:33
 */
public class DittoEventHandler implements EventHandler<DittoEvent> {

    @Override
    public void onEvent(DittoEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("event body ===>" + event.getBody() + "sequence ===> " + sequence);
    }
}
